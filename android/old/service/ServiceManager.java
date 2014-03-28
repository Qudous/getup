package com.aapsdevelopment.getup.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;

import com.aapsdevelopment.getup.manager.ContextManager;

public class ServiceManager
{
	static private int MAX_SERVICES = 100;

	private static ServiceManager singleton = new ServiceManager();

	private final Map<Class<? extends AbstractService>, AbstractService> services = new Hashtable<Class<? extends AbstractService>, AbstractService>();

	private ServiceManager()
	{

	}

	public static ServiceManager getInstance()
	{
		return ServiceManager.singleton;
	}

	@SuppressWarnings( "unchecked" )
	public <T> T getService( final Class<? extends AbstractService> klass ) throws UnknowServiceException
	{
		if ( this.services.containsKey( klass ) )
		{
			return (T) this.services.get( klass );
		}

		throw new UnknowServiceException( klass );
	}

	public void startService( final Class<? extends AbstractService> klass, String... parameters ) throws ClassNotFoundException
	{
		final Context context = ContextManager.getInstance().getContext();

		final Intent intent = new Intent( context, klass );

		if ( parameters.length % 2 == 0 )
		{
			for ( int i = 0; i < parameters.length; i += 2 )
				intent.putExtra( parameters[i], parameters[i + 1] );
		}

		context.startService( intent );
	}

	public void registerService( final AbstractService service )
	{
		if ( null != service )
		{
			this.services.put( service.getClass(), service );
		}
	}

	public List<RunningServiceInfo> getRunningServices( final int maxNum )
	{
		final Context context = ContextManager.getInstance().getContext();

		final android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService( Context.ACTIVITY_SERVICE );

		return activityManager.getRunningServices( maxNum );
	}

	@SuppressWarnings( "unchecked" )
	public <T> T getRunningService( final Class<T> klass ) throws ClassNotFoundException
	{
		final T service = null;

		for ( final RunningServiceInfo runningServiceInfo : this.getRunningServices( ServiceManager.MAX_SERVICES ) )
		{
			final String klassName = runningServiceInfo.service.getClassName();

			final Object object = new Intent( klassName );

			if ( object.getClass().isInstance( klass ) || object.getClass().isAssignableFrom( klass ) )
			{
				return (T) object;
			}
		}

		return service;
	}

	public void destroyAllService()
	{
		for ( final Class<? extends AbstractService> key : this.services.keySet() )
		{
			final AbstractService toDestroy = this.services.get( key );

			toDestroy.destroy();
		}
	}

	public void destroy( final Class<? extends AbstractService> klass ) throws UnknowServiceException
	{
		final AbstractService service = this.getService( klass );

		if ( null != service )
		{
			service.destroy();
		}
	}

	public void destroy( final Intent bind )
	{
		if ( null != bind )
		{
			final Context context = ContextManager.getInstance().getContext();

			context.stopService( bind );
		}
	}
}

package com.aapsdevelopment.getup.event;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aapsdevelopment.getup.event.impl.ErrorEvent;

import android.os.Looper;
import android.util.Log;

public class EventManager
{
	private static EventManager instance;

	private Map<Class<?>, List<IEventListener>> listeners;

	private EventManager()
	{
		listeners = new Hashtable<Class<?>, List<IEventListener>>();
	}

	public final static EventManager getInstance()
	{
		if ( EventManager.instance == null )
		{
			synchronized ( EventManager.class )
			{
				if ( EventManager.instance == null )
				{
					EventManager.instance = new EventManager();
				}
			}
		}

		return EventManager.instance;
	}

	public void addListener( final IEventListener listener )
	{
		final Class<?>[] classes = listener.getTarget();
		if ( classes == null )
			return;

		for ( final Class<?> cls : classes )
		{
			this.addListener( cls, listener );
		}
	}

	private void addListener( final Class<?> klass, final IEventListener listener )
	{
		if ( !this.contains( listener, klass ) )
		{
			if ( !listeners.containsKey( klass ) )
			{
				listeners.put( klass, new LinkedList<IEventListener>() );
			}

			listeners.get( klass ).add( listener );
		}
	}

	public void removeListener( final IEventListener listener )
	{
		final Set<Class<?>> keys = listeners.keySet();

		for ( final Class<?> klass : keys )
		{
			listeners.get( klass ).remove( listener );
		}
	}

	public void sendEvent( final IEvent event )
	{
		final boolean isUiThread = ( Looper.myLooper() == Looper.getMainLooper() );

		if ( !isUiThread )
			return;

		if ( listeners.containsKey( event.getClass() ) )
		{
			for ( final IEventListener listener : listeners.get( event.getClass() ) )
			{
				try
				{
					listener.onEvent( event );
				}
				catch ( final Exception e )
				{
					EventManager.getInstance().sendException( this, e );
				}
			}
		}
	}

	public void sendException( final Object source, final Exception exception )
	{
		Log.w( source.getClass().getCanonicalName(), exception );

		this.sendEvent( new ErrorEvent( source, exception ) );
	}

	private boolean contains( final IEventListener target, final Class<?> klass )
	{
		boolean find = false;

		if ( listeners.containsKey( klass ) )
		{
			for ( final IEventListener listener : listeners.get( klass ) )
			{
				if ( listener == target )
				{
					find = true;
					break;
				}
			}
		}

		return find;
	}
}

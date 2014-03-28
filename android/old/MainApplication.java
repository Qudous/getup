package com.aapsdevelopment.getup;

import android.app.Application;
import android.util.Log;

import com.aapsdevelopment.getup.manager.ContextManager;
import com.aapsdevelopment.getup.service.ServiceManager;
import com.aapsdevelopment.getup.service.UnknowServiceException;
import com.aapsdevelopment.getup.service.impl.AlarmService;

public class MainApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();

		this.initContext();
		this.initServices();
	}

	private void initContext()
	{
		ContextManager.getInstance().setContext( getApplicationContext() );
	}

	private void initServices()
	{
		try
		{
			this.initAlarmService();
		}
		catch ( Exception e )
		{
			Log.w( this.getClass().getSimpleName(), e.getMessage() );
		}
	}

	private void initAlarmService() throws ClassNotFoundException
	{
		try
		{
			ServiceManager.getInstance().getService( AlarmService.class );
		}
		catch ( UnknowServiceException e )
		{
			ServiceManager.getInstance().startService( AlarmService.class );
		}
	}
}

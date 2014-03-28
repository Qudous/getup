package com.aapsdevelopment.getup.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

abstract public class AbstractService extends Service implements IService
{
	protected Intent bind;

	@Override
	public void onCreate()
	{
		super.onCreate();

		ServiceManager.getInstance().registerService( this );
	}

	public void destroy()
	{
		this.stopSelf();
	}

	@Override
	public IBinder onBind( final Intent intent )
	{
		this.bind = intent;

		return null;
	}
}

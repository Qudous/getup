package com.aapsdevelopment.getup;

import com.aapsdevelopment.getup.manager.ContextManager;

import android.app.Application;

public class MainApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();

		ContextManager.getInstance().setContext( getApplicationContext() );
	}
}

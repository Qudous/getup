package com.aapsdevelopment.getup;

import android.app.Application;

import com.aapsdevelopment.getup.manager.ContextManager;

public class MainApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();

		this.initContext();
	}

	private void initContext()
	{
		ContextManager.getInstance().setContext( getApplicationContext() );
	}
}

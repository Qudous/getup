package com.aapsdevelopment.getup.manager;

import android.content.Context;

public class ContextManager
{
	static private ContextManager _instance = new ContextManager();

	private Context context;

	private ContextManager()
	{

	}

	static public ContextManager getInstance()
	{
		return ContextManager._instance;
	}

	public Context getContext()
	{
		return context;
	}

	public void setContext( Context context )
	{
		this.context = context;
	}
}

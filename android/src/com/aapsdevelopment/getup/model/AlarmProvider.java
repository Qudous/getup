package com.aapsdevelopment.getup.model;

public class AlarmProvider
{
	static private AlarmProvider _instance = new AlarmProvider();

	private AlarmProvider()
	{

	}

	static public AlarmProvider getInstance()
	{
		return AlarmProvider._instance;
	}

	public Alarm getAt( int position )
	{
		return new Alarm( 1, "TEST", 0, 0, 0, 0 );
	}

	public Alarm getById( long id )
	{
		return new Alarm( id, "TEST", 0, 0, 0, 0 );
	}
}

package com.aapsdevelopment.getup.event.impl;

public class AlarmEvent extends DefaultEvent
{
	static public final int ACTION_FRAGMENT = 1;

	private long alarm;

	private int action;

	public AlarmEvent( Object source, Object object, long alarm, int action )
	{
		super( source, object );

		this.alarm = alarm;
		this.action = action;
	}

	public long getAlarm()
	{
		return alarm;
	}

	public int getAction()
	{
		return action;
	}

}

package com.aapsdevelopment.getup.event.impl;

import com.aapsdevelopment.getup.event.IEvent;

public class DefaultEvent implements IEvent
{
	private final Object source;

	private final Object object;

	public DefaultEvent( final Object source, final Object object )
	{
		this.source = source;
		this.object = object;
	}

	@Override
	public Object getSource()
	{
		return source;
	}

	@Override
	public Object getObject()
	{
		return object;
	}
}

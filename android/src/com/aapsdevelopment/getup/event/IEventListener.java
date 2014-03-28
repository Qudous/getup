package com.aapsdevelopment.getup.event;

public interface IEventListener
{
	public boolean onEvent( IEvent event ) throws Exception;

	public Class<?>[] getTarget();
}

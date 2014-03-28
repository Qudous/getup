package com.aapsdevelopment.getup.event.impl;

import com.aapsdevelopment.getup.event.IEvent;

public class ErrorEvent extends DefaultEvent implements IEvent
{

	public ErrorEvent( final Object source, final Throwable throwable )
	{
		super( source, throwable );
	}

	public Throwable getThrowable()
	{
		return (Throwable) super.getObject();
	}

	@Override
	public Object getObject()
	{
		if ( getThrowable() == null && super.getSource() == null )
			return "";

		StringBuilder builder = new StringBuilder();

		if ( super.getSource() != null )
		{
			builder.append( super.getSource().getClass().getName() );
		}

		if ( getThrowable() == null )
		{
			return builder.toString();
		}

		if ( getThrowable().getMessage().length() != 0 )
		{
			builder.append( getThrowable().getClass().getName() );
			builder.append( getThrowable().getMessage() );
		}

		if ( getThrowable().getCause() != null )
		{
			builder.append( "\n\nCause:\n" );
			builder.append( getThrowable().getCause().getClass().getName() );
			builder.append( getThrowable().getCause().getMessage() );
		}

		if ( builder.toString().length() == 0 )
			return getThrowable().toString();
		else
			return builder.toString();
	}
}

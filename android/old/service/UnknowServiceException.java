package com.aapsdevelopment.getup.service;

@SuppressWarnings( "serial" )
public class UnknowServiceException extends Exception
{
	private final String klass;

	public UnknowServiceException( final String klass )
	{
		this.klass = klass;
	}

	public UnknowServiceException( final Class<?> klass )
	{
		this.klass = ( null != klass ) ? klass.getClass().getName() : null;
	}

	@Override
	public String getMessage()
	{
		final StringBuilder builder = new StringBuilder();

		builder.append( "Service " );
		builder.append( "[" );
		builder.append( this.klass );
		builder.append( "]" );
		builder.append( " not found" );

		return builder.toString();
	}
}

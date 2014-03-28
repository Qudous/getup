package com.aapsdevelopment.getup.utils;

import java.util.Calendar;

public class DateUtils
{
	static public Calendar toCalendar( long hour )
	{
		Calendar calNow = Calendar.getInstance();
		Calendar calSet = (Calendar) calNow.clone();

		calSet.set( Calendar.HOUR_OF_DAY, calNow.get( Calendar.HOUR_OF_DAY ) );
		calSet.set( Calendar.MINUTE, calNow.get( Calendar.MINUTE ) );
		calSet.set( Calendar.SECOND, calNow.get( Calendar.SECOND ) + 3 );
		calSet.set( Calendar.MILLISECOND, 0 );

		return calSet;
	}
}

package com.aapsdevelopment.getup.utils;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.aapsdevelopment.getup.manager.ContextManager;

public class AlarmUtils
{
	static public void setAlarm( Class<? extends BroadcastReceiver> receiver, Calendar calendar, String action, Object... parameters )
	{
		Context contex = ContextManager.getInstance().getContext();

		Intent intent = new Intent( contex, receiver );

		intent.setAction( action );

		AlarmUtils.putParamters( intent, parameters );

		PendingIntent pendingIntent = PendingIntent.getBroadcast( contex, 0, intent, 0 );

		AlarmManager alarmManager = (AlarmManager) contex.getSystemService( Context.ALARM_SERVICE );

		alarmManager.set( AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent );
	}

	private static void putParamters( Intent intent, Object[] parameters )
	{
		if ( parameters.length % 2 == 0 )
		{
			for ( int i = 0; i < parameters.length / 2; i += 2 )
			{
				if ( parameters[i] instanceof String && parameters[i + 1] instanceof Long )
				{
					intent.putExtra( (String) parameters[i], (Long) parameters[i + 1] );
				}
			}
		}
	}
}

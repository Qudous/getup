package com.aapsdevelopment.getup.service.impl;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.aapsdevelopment.getup.receiver.AlarmReceiver;
import com.aapsdevelopment.getup.service.AbstractService;
import com.aapsdevelopment.getup.ui.activity.QuestionActivity;

public class AlarmService extends AbstractService
{
	final static int RQS_1 = 1;

	@Override
	public void onCreate()
	{
		super.onCreate();

		System.out.println( "AlarmService.onCreate()" );

		Calendar calNow = Calendar.getInstance();
		Calendar calSet = (Calendar) calNow.clone();

		calSet.set( Calendar.HOUR_OF_DAY, calNow.get( Calendar.HOUR_OF_DAY ) );
		calSet.set( Calendar.MINUTE, calNow.get( Calendar.MINUTE ) );
		calSet.set( Calendar.SECOND, calNow.get( Calendar.SECOND ) + 10 );
		calSet.set( Calendar.MILLISECOND, 0 );

		Intent intent = new Intent( getBaseContext(), AlarmReceiver.class );

		PendingIntent pendingIntent = PendingIntent.getBroadcast( getBaseContext(), RQS_1, intent, 0 );
		
		AlarmManager alarmManager = (AlarmManager) getSystemService( Context.ALARM_SERVICE );

		alarmManager.set( AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), pendingIntent );
		
		PendingIntent pendingIntent2 = PendingIntent.getBroadcast( getBaseContext(), RQS_1, intent, 0 );
		
		alarmManager.cancel( pendingIntent2 );
	}

	@Override
	public IBinder onBind( Intent intent )
	{
		super.onBind( intent );

		return null;
	}
}

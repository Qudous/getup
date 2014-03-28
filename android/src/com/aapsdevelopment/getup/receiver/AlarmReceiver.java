package com.aapsdevelopment.getup.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.aapsdevelopment.getup.MainContants;
import com.aapsdevelopment.getup.ui.activity.QuestionActivity;

public class AlarmReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive( Context context, Intent intent )
	{
		try
		{
			String action = intent.getAction();

			if ( action.equals( Intent.ACTION_BOOT_COMPLETED ) )
				this.actionBootCompleted(context);

			if ( action.equals( MainContants.ACTION_RUN_ALARM ) )
				this.actionRunAlarm(context);
		}
		catch ( Exception e )
		{
			Log.w( this.getClass().getSimpleName(), e.getMessage() );
		}
	}

	private void actionBootCompleted(Context context)
	{

	}

	private void actionRunAlarm(Context context)
	{
		Intent questionIntent = new Intent( context, QuestionActivity.class );

		questionIntent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
		questionIntent.addFlags( Intent.FLAG_ACTIVITY_NO_HISTORY );

		context.startActivity( questionIntent );
	}
}

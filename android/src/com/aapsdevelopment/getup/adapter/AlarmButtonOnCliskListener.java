package com.aapsdevelopment.getup.adapter;

import android.view.View;
import android.view.View.OnClickListener;

import com.aapsdevelopment.getup.event.EventManager;
import com.aapsdevelopment.getup.event.impl.AlarmEvent;

public class AlarmButtonOnCliskListener implements OnClickListener
{
	private long alarmId;

	public AlarmButtonOnCliskListener( long alarmId )
	{
		this.alarmId = alarmId;
	}

	@Override
	public void onClick( View v )
	{
		EventManager.getInstance().sendEvent( new AlarmEvent( this, this, this.alarmId, AlarmEvent.ACTION_FRAGMENT ) );
	}
}

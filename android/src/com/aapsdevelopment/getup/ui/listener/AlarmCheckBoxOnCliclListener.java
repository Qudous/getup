package com.aapsdevelopment.getup.ui.listener;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.aapsdevelopment.getup.MainContants;
import com.aapsdevelopment.getup.model.Alarm;
import com.aapsdevelopment.getup.model.AlarmProvider;
import com.aapsdevelopment.getup.receiver.AlarmReceiver;
import com.aapsdevelopment.getup.utils.AlarmUtils;
import com.aapsdevelopment.getup.utils.DateUtils;

public class AlarmCheckBoxOnCliclListener implements OnCheckedChangeListener
{
	private long alaramId;

	public AlarmCheckBoxOnCliclListener( long alaramId )
	{
		this.alaramId = alaramId;
	}

	@Override
	public void onCheckedChanged( CompoundButton buttonView, boolean isChecked )
	{
		Alarm alarm = AlarmProvider.getInstance().getById( alaramId );

		if ( null != alarm )
		{
			AlarmUtils.setAlarm( AlarmReceiver.class, DateUtils.toCalendar( 0 ), MainContants.ACTION_RUN_ALARM, MainContants.ALARM_ID, alarm.getId() );
		}
	}
}

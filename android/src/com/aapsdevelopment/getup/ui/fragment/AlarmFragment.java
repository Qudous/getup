package com.aapsdevelopment.getup.ui.fragment;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.aapsdevelopment.getup.MainContants;
import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.model.Alarm;
import com.aapsdevelopment.getup.model.AlarmProvider;
import com.aapsdevelopment.getup.utils.ViewUtils;

public class AlarmFragment extends Fragment
{
	private Alarm alarm;

	public AlarmFragment()
	{
		super();
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View rootView = inflater.inflate( R.layout.fragment_alarm, container, false );

		if ( rootView instanceof ViewGroup )
		{
			this.initData();
			this.initView( (ViewGroup) rootView );
			this.updateForm();
		}

		return rootView;
	}

	private void initView( ViewGroup container )
	{
		this.initTimePicker( (TimePicker) container.findViewById( R.id.AlarmHourTimePicker ) );
	}

	private void initTimePicker( TimePicker piker )
	{
		if ( null != piker )
		{
			piker.setIs24HourView( true );

			if ( null != this.alarm && this.alarm.getId() > 0 )
			{

			}
			else
			{
				piker.setCurrentHour( Calendar.getInstance().get( Calendar.HOUR_OF_DAY ) );
				piker.setCurrentMinute( ( Calendar.getInstance().get( Calendar.MINUTE ) ) );
			}
		}
	}

	private void initData()
	{
		long id = this.getArguments().getLong( MainContants.ALARM_ID );

		if ( id > 0 )
			this.alarm = AlarmProvider.getInstance().getById( id );
	}

	private void updateForm()
	{
		if ( null != this.alarm )
		{
			ViewUtils.updateTextView( this.getView(), R.id.AlarmNameTextView, alarm.getTitle() );
		}
	}
}

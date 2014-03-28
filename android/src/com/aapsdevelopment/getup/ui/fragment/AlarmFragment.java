package com.aapsdevelopment.getup.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.model.Alarm;
import com.aapsdevelopment.getup.model.AlarmProvider;
import com.aapsdevelopment.getup.utils.ViewUtils;

public class AlarmFragment extends Fragment
{
	static public final String ALARM_ID = "ALARM_ID";

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
			this.initView( (ViewGroup) rootView );
			this.initData();
			this.updateForm();
		}

		return rootView;
	}

	private void initView( ViewGroup container )
	{}

	private void initData()
	{
		long id = this.getArguments().getLong( ALARM_ID );

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

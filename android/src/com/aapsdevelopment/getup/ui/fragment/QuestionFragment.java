package com.aapsdevelopment.getup.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aapsdevelopment.getup.MainContants;
import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.utils.ViewUtils;

public class QuestionFragment extends Fragment
{

	private long alarmId;

	public QuestionFragment()
	{
		super();
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View rootView = inflater.inflate( R.layout.fragment_question, container, false );

		if ( rootView instanceof ViewGroup )
		{
			this.initData();
			this.initView( (ViewGroup) rootView );
			this.updateForm();
		}

		return rootView;
	}

	private void initView( ViewGroup container )
	{}

	private void initData()
	{
		if ( null != this.getArguments() && this.getArguments().containsKey( MainContants.ALARM_ID ) )
		{
			alarmId = this.getArguments().getLong( MainContants.ALARM_ID );
		}
	}

	private void updateForm()
	{
		ViewUtils.updateTextView( this.getView(), R.id.QuestionNameTextView, "Question for alarm[" + alarmId + "]" );
	}
}

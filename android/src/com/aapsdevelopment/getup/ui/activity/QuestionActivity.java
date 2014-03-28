package com.aapsdevelopment.getup.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.aapsdevelopment.getup.MainContants;
import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.ui.fragment.QuestionFragment;
import com.aapsdevelopment.getup.utils.FragmentUtils;

public class QuestionActivity extends FragmentActivity
{
	private long alarmId;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		setContentView( R.layout.activity_main );

		this.initData();
		this.initFragment( savedInstanceState );
	}

	private void initData()
	{
		this.alarmId = this.getIntent().getLongExtra( MainContants.ALARM_ID, 0 );
	}

	private void initFragment( Bundle savedInstanceState )
	{
		if ( savedInstanceState == null )
		{
			QuestionFragment fragment = new QuestionFragment();

			FragmentUtils.setArguments( fragment, MainContants.ALARM_ID, this.alarmId );

			getSupportFragmentManager().beginTransaction().add( R.id.Container, new QuestionFragment() ).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		return false;
	}
}
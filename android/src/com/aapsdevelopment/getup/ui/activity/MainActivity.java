package com.aapsdevelopment.getup.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.aapsdevelopment.getup.MainContants;
import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.event.EventManager;
import com.aapsdevelopment.getup.event.IEvent;
import com.aapsdevelopment.getup.event.IEventListener;
import com.aapsdevelopment.getup.event.impl.AlarmEvent;
import com.aapsdevelopment.getup.ui.fragment.AlarmFragment;
import com.aapsdevelopment.getup.ui.fragment.AlarmsFragment;
import com.aapsdevelopment.getup.utils.FragmentUtils;

public class MainActivity extends FragmentActivity implements IEventListener
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		setContentView( R.layout.activity_main );

		this.initListener();
		this.initFragment( savedInstanceState );
	}

	private void initListener()
	{
		EventManager.getInstance().addListener( this );
	}

	private void initFragment( Bundle savedInstanceState )
	{
		if ( savedInstanceState == null )
		{
			getSupportFragmentManager().beginTransaction().add( R.id.Container, new AlarmsFragment() ).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.menus, menu );

		return true;
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();

		EventManager.getInstance().removeListener( this );
	}

	@Override
	public boolean onEvent( IEvent event ) throws Exception
	{
		if ( event instanceof AlarmEvent )
			this.onAlarmEvent( (AlarmEvent) event );

		return false;
	}

	private void onAlarmEvent( AlarmEvent event )
	{
		AlarmFragment fragment = new AlarmFragment();

		FragmentUtils.setArguments( fragment, MainContants.ALARM_ID, event.getAlarm() );
		FragmentUtils.pushFragment( this, fragment );
	}

	@Override
	public Class<?>[] getTarget()
	{
		return new Class<?>[] { AlarmEvent.class };
	}
}

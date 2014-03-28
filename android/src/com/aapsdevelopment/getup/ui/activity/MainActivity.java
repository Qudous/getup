package com.aapsdevelopment.getup.ui.activity;

import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.R.id;
import com.aapsdevelopment.getup.R.layout;
import com.aapsdevelopment.getup.R.menu;
import com.aapsdevelopment.getup.ui.fragment.AlarmsFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity
{
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );

		setContentView( R.layout.activity_main );

		this.initFragment( savedInstanceState );
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
}

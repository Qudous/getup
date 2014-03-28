package com.aapsdevelopment.getup.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.adapter.AlarmsAdapter;

public class AlarmsFragment extends Fragment
{
	private GridView alarmsGridView;

	public AlarmsFragment()
	{}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View rootView = inflater.inflate( R.layout.fragment_alarms, container, false );

		if ( rootView instanceof ViewGroup )
		{
			this.initView( (ViewGroup) rootView );
			this.initData();
		}

		return rootView;
	}

	private void initView( ViewGroup container )
	{
		alarmsGridView = (GridView) container.findViewById( R.id.AlaramsGridView );
	}

	private void initData()
	{
		if ( null != alarmsGridView )
			alarmsGridView.setAdapter( new AlarmsAdapter() );
	}
}

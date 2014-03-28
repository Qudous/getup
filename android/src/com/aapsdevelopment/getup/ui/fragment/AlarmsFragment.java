package com.aapsdevelopment.getup.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;

import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.adapter.AlarmsAdapter;
import com.aapsdevelopment.getup.utils.FragmentUtils;

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
		alarmsGridView.setOnItemClickListener( new AlarmOnItemClickListener() );
		alarmsGridView.setOnItemLongClickListener( new OnItemLongClickListener()
		{

			@Override
			public boolean onItemLongClick( AdapterView<?> parent, View view, int position, long id )
			{
				AlarmFragment fragment = new AlarmFragment();

				FragmentUtils.setArguments( fragment, AlarmFragment.ALARM_ID, id );
				FragmentUtils.pushFragment( getActivity(), fragment );

				return false;
			}

		} );
		alarmsGridView.setOnItemSelectedListener( new OnItemSelectedListener()
		{

			@Override
			public void onItemSelected( AdapterView<?> parent, View view, int position, long id )
			{
				AlarmFragment fragment = new AlarmFragment();

				FragmentUtils.setArguments( fragment, AlarmFragment.ALARM_ID, id );
				FragmentUtils.pushFragment( getActivity(), fragment );
			}

			@Override
			public void onNothingSelected( AdapterView<?> parent )
			{

			}
		} );
	}

	private void initData()
	{
		if ( null != alarmsGridView )
			alarmsGridView.setAdapter( new AlarmsAdapter() );
	}

	class AlarmOnItemClickListener implements OnItemClickListener
	{
		@Override
		public void onItemClick( AdapterView<?> parent, View view, int position, long id )
		{
			AlarmFragment fragment = new AlarmFragment();

			FragmentUtils.setArguments( fragment, AlarmFragment.ALARM_ID, id );
			FragmentUtils.pushFragment( getActivity(), fragment );
		}
	}
}

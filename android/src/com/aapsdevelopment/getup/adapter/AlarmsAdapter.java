package com.aapsdevelopment.getup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aapsdevelopment.getup.R;
import com.aapsdevelopment.getup.manager.ContextManager;
import com.aapsdevelopment.getup.model.Alarm;
import com.aapsdevelopment.getup.model.AlarmProvider;
import com.aapsdevelopment.getup.ui.listener.AlarmCheckBoxOnCliclListener;
import com.aapsdevelopment.getup.utils.ViewUtils;

public class AlarmsAdapter extends BaseAdapter
{
	@Override
	public int getCount()
	{
		return 10;
	}

	@Override
	public Object getItem( int position )
	{
		return AlarmProvider.getInstance().getAt( position );
	}

	@Override
	public long getItemId( int position )
	{
		Object object = this.getItem( position );

		if ( object instanceof Alarm )
			return ( (Alarm) object ).getId();

		return 0;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent )
	{
		if ( null == convertView )
			convertView = this.createConvertView();

		if ( null != convertView )
			this.updateView( convertView, AlarmProvider.getInstance().getAt( position ) );

		return convertView;
	}

	private View createConvertView()
	{
		Context context = ContextManager.getInstance().getContext();

		LayoutInflater layoutInflater = LayoutInflater.from( context );

		return layoutInflater.inflate( R.layout.cell_alarm, null );
	}

	private void updateView( View convertView, Alarm alarm )
	{
		ViewUtils.updateTextView( convertView, R.id.AlarmNameTextView, alarm.getTitle() );
		ViewUtils.updateTextView( convertView, R.id.AlarmHourTextView, String.valueOf( alarm.getHour() ) + ":" + String.valueOf( alarm.getMinute() ) );
		ViewUtils.updateCheckbox( convertView, R.id.AlarmEnableCheckBox, new AlarmCheckBoxOnCliclListener( alarm.getId() ) );
		ViewUtils.updateImageButton( convertView, R.id.AlarmConfigImageButton, new AlarmButtonOnCliskListener( alarm.getId() ) );
	}
}

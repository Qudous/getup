package com.aapsdevelopment.getup.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewUtils
{
	public static void updateTextView( View view, int id, String text )
	{
		if ( null != view )
		{
			TextView textView = (TextView) view.findViewById( id );

			if ( null != textView )
				textView.setText( text );
		}
	}

	public static void updateCheckbox( View view, int id, OnCheckedChangeListener onCheckedChangeListener )
	{
		if ( null != view )
		{
			CheckBox checkBox = (CheckBox) view.findViewById( id );

			if ( null != checkBox )
				checkBox.setOnCheckedChangeListener( onCheckedChangeListener );
		}
	}

	public static void updateButton( View view, int id, OnClickListener onClickListener )
	{
		if ( null != view )
		{
			Button button = (Button) view.findViewById( id );

			if ( null != button )
				button.setOnClickListener( onClickListener );
		}
	}

	public static void updateImageButton( View view, int id, OnClickListener onClickListener )
	{
		if ( null != view )
		{
			ImageButton button = (ImageButton) view.findViewById( id );

			if ( null != button )
				button.setOnClickListener( onClickListener );
		}
	}
}

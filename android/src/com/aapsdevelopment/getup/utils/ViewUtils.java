package com.aapsdevelopment.getup.utils;

import android.view.View;
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
}

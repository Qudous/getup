package com.aapsdevelopment.getup;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GetUpActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_get_up);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.get_up, menu);
		
		return true;
	}
}

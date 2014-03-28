package com.aapsdevelopment.getup.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class FragmentUtils
{
	static public void pushFragment( final FragmentActivity fragmentActivity, final Fragment fragment )
	{
		final View rootView = fragmentActivity.getWindow().getDecorView().findViewById( android.R.id.content );

		final FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
		final FragmentTransaction transaction = fragmentManager.beginTransaction();

		transaction.replace( rootView.getId(), fragment );
		transaction.addToBackStack( fragment.toString() );
		transaction.commit();
	}

	public static void popFragment( final FragmentActivity fragmentActivity, final Fragment fragment )
	{
		final FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
		final FragmentTransaction transaction = fragmentManager.beginTransaction();

		fragmentManager.popBackStack();

		transaction.remove( fragment );
		transaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_CLOSE );
		transaction.commit();
	}

	public static void setArguments( final Fragment fragment, String key, long value )
	{
		Bundle bundle = new Bundle();

		bundle.putLong( key, value );

		fragment.setArguments( bundle );
	}
}
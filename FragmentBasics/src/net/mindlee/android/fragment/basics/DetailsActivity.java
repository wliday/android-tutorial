package net.mindlee.android.fragment.basics;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

public class DetailsActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getResources().getConfiguration().orientation 
				== Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}

		if (getIntent() != null) {
			//从intent取出索引值，利用此值实例化DetailsFragment
			DetailsFragment details = DetailsFragment.newInstance(getIntent()
					.getExtras());
			
			FragmentTransaction ft = getFragmentManager()
					.beginTransaction();
			ft.add(android.R.id.content, details).commit();
		}
	}
}

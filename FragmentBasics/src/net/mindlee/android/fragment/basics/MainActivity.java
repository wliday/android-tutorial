package net.mindlee.android.fragment.basics;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	// 是否是多窗口
	public boolean isMultiPane() {
		return getResources().getConfiguration().orientation 
				== Configuration.ORIENTATION_LANDSCAPE;
	}

	public void showDetails(int index) {
		if (isMultiPane()) {// 如果是横屏(多窗口), 使用DetailsFragment
			DetailsFragment details = (DetailsFragment) getFragmentManager()
					.findFragmentById(R.id.details);

			if (details == null || details.getShownIndex() != index) {
				details = DetailsFragment.newInstance(index);

				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.replace(R.id.details, details);
				ft.addToBackStack("details");
				ft.commit();
			}
		} else {// 如果是竖屏，调用DetailsActivity，将当前索引值存入intent
			Intent intent = new Intent();
			intent.setClass(this, DetailsActivity.class);
			intent.putExtra("index", index);
			startActivity(intent);
		}
	}
}
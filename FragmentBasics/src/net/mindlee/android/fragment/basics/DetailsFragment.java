package net.mindlee.android.fragment.basics;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
	private int mIndex = 0;

	public static DetailsFragment newInstance(int index) {
		DetailsFragment df = new DetailsFragment();
		Bundle args = new Bundle();
		args.putInt("index", index);
		df.setArguments(args);
		return df;
	}

	public static DetailsFragment newInstance(Bundle bundle) {
		int index = bundle.getInt("index", 0);
		return newInstance(index);
	}

	public void onCreate(Bundle myBundle) {
		super.onCreate(myBundle);
		mIndex = getArguments().getInt("index", 0);
	}

	public int getShownIndex() {
		return mIndex;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.details, container, false);
		TextView text1 = (TextView) v.findViewById(R.id.text1);
		text1.setText(Shakespeare.DIALOGUE[mIndex]);
		return v;
	}
}
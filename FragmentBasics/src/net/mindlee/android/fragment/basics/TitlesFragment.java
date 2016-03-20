package net.mindlee.android.fragment.basics;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {
	private MainActivity myActivity = null;
	int mCurCheckPosition = 0;

	public void onAttach(Activity myActivity) {
		super.onAttach(myActivity);
		this.myActivity = (MainActivity) myActivity;
	}

	@Override
	public void onActivityCreated(Bundle icicle) {
		super.onActivityCreated(icicle);
		if (icicle != null) {
			mCurCheckPosition = icicle.getInt("curChoice", 0);
		}

		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, Shakespeare.TITLES));

		ListView lv = getListView();
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lv.setSelection(mCurCheckPosition);

		myActivity.showDetails(mCurCheckPosition);
	}

	@Override
	public void onSaveInstanceState(Bundle icicle) {
		super.onSaveInstanceState(icicle);
		icicle.putInt("curChoice", mCurCheckPosition);
	}

	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		myActivity.showDetails(pos);
		mCurCheckPosition = pos;
	}
}

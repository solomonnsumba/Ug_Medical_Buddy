package com.ugmedicalbuddy.orange;

//import android.annotation.TargetApi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListFragment;
import android.os.Build;
//import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
//import course.examples.UI.FragmentActionBar.R;

//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class TitlesFragment extends ListFragment {
	ListSelectionListener mListener = null;
	int mCurrIdx = -1;

	public interface ListSelectionListener {
		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		public void onListSelection(int index);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (ListSelectionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnArticleSelectedListener");
		}
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setHasOptionsMenu(true);
		setRetainInstance(true);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onActivityCreated(Bundle savedState) {
		super.onActivityCreated(savedState);

		setListAdapter(new ArrayAdapter<String>(getActivity(),
				R.layout.list_item, QuoteViewerActivity.TitleArray));
		if (mCurrIdx != -1) {
			setSelection(mCurrIdx);
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int pos, long id) {
		mCurrIdx = pos;
		getListView().setItemChecked(pos, true);
		mListener.onListSelection(pos);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.title_menu, menu);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.title_menu_item:
			Toast.makeText(getActivity().getApplicationContext(),
					"This action provided by the TitlesFragment",
					Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
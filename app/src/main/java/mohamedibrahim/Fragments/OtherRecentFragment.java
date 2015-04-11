package mohamedibrahim.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mohamedibrahim.Adapters.MyListCursorAdapter;
import mohamedibrahim.sampleproject.R;

/**
 * Created by Mohamed on 4/6/2015.
 */
public class OtherRecentFragment extends BaseFragment {

    // list
    private MyListCursorAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Cursor mCursor;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView mRecyclerView;

    @Override
    public String getFragmentName() {
        return "ANOTHER RECENT";
    }


        public static OtherRecentFragment newInstance() {
        OtherRecentFragment fragment = new OtherRecentFragment();
        return fragment;
    }

    public OtherRecentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mCursor == null)
            mCursor = getActivity().getContentResolver().query(android.provider.CallLog.Calls.CONTENT_URI, null, null, null, null);

        mAdapter = new MyListCursorAdapter(getActivity(), mCursor);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void getRecentCallLogs() {

        // for all types call
        Cursor cursor = getActivity().getContentResolver().query(android.provider.CallLog.Calls.CONTENT_URI, null, null, null, null);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recent, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        return v;
    }


}

package mohamedibrahim.Fragments;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import mohamedibrahim.Adapters.CustomPhoneAdatper;
import mohamedibrahim.model.ContactModel;
import mohamedibrahim.sampleproject.Constants;
import mohamedibrahim.sampleproject.R;


public class RecentFragment extends BaseFragment {

    // list
    private CustomPhoneAdatper mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ContactModel> listOfContacts;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView mRecyclerView;

    @Override
    public String getFragmentName() {
        return "RECENT";
    }


    public static RecentFragment newInstance() {
        RecentFragment fragment = new RecentFragment();
        return fragment;
    }

    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (listOfContacts == null) {
            fillListOfContacts();
        }
    }


    private void getRecentCallLogs() {

        // for all types call
        Cursor cursor = getActivity().getContentResolver().query(android.provider.CallLog.Calls.CONTENT_URI, null, null, null, null);

    }

    private void fillListOfContacts() {


        listOfContacts = new ArrayList<>();
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.INCOMING));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.INCOMING));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.MISSED));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.MISSED));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.OUT));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.OUT));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.MISSED));
        listOfContacts.add(new ContactModel("0125454545", new Date(), Constants.INCOMING));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recent, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CustomPhoneAdatper(getActivity(), listOfContacts);
        mRecyclerView.setAdapter(mAdapter);


        return v;
    }


}

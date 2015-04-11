package mohamedibrahim.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mohamedibrahim.Adapters.DummyCardAdapter;
import mohamedibrahim.sampleproject.R;

/**
 * Created by MohamedIbrahim on 11/04/2015.
 */
public class CardsFragment extends BaseFragment {


    public CardsFragment() {
        // Required empty public constructor
    }

    public static CardsFragment newInstance() {
        CardsFragment fragment = new CardsFragment();
        return fragment;
    }


    @Override
    public String getFragmentName() {
        return "Cards";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cards, container, false);
        RecyclerView rvDummyCards = (RecyclerView) v.findViewById(R.id.rvDummyCards);
        rvDummyCards.setHasFixedSize(true); // optimize the recycle of view
        rvDummyCards.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDummyCards.setAdapter(new DummyCardAdapter(45));
        return v;

    }
}

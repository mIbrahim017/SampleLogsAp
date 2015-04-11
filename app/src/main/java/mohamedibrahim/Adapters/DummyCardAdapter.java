package mohamedibrahim.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import mohamedibrahim.sampleproject.R;

/**
 * Created by Lenovo on 11/04/2015.
 */
public class DummyCardAdapter extends RecyclerView.Adapter<DummyCardAdapter.CardViewHolder> {

    private int mCardsNum;

    public DummyCardAdapter(int numCards) {
        mCardsNum = numCards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        CardViewHolder vh = new CardViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {

        cardViewHolder.setText(i);
    }

    @Override
    public int getItemCount() {
        return mCardsNum;
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCount;

        public CardViewHolder(LinearLayout itemView) {
            super(itemView);
            tvCount = (TextView) itemView.findViewById(R.id.tvCount);
        }

        public void setText(int i) {
            tvCount.setText("This is card : " + i);
        }
    }
}

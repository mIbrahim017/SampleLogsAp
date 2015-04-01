package mohamedibrahim.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import mohamedibrahim.model.ContactModel;
import mohamedibrahim.sampleproject.R;

/**
 * Created by Mohamed on 4/1/2015.
 */
public class CustomPhoneAdatper extends RecyclerView.Adapter<CustomPhoneAdatper.RecyclerViewHolder> {


    private Context context;
    private ArrayList<ContactModel> listOfContacts;
    LayoutInflater inflater;


    // constructor
    public CustomPhoneAdatper(Context context, ArrayList<ContactModel> listOfContacts) {
        this.context = context;
        this.listOfContacts = listOfContacts;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new RecyclerViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {

        if (listOfContacts != null) {
            recyclerViewHolder.ivPhoneType.setImageResource(listOfContacts.get(i).getPhoneType());

            String monthName = new SimpleDateFormat("MMMM dd").format(listOfContacts.get(i).getCallDate());
            recyclerViewHolder.tvPhoneData.setText(monthName);
            recyclerViewHolder.tvPhoneNumber.setText(listOfContacts.get(i).getPhoneNumber());
        }
    }

    @Override
    public int getItemCount() {
        if (listOfContacts == null) return 0;
        return listOfContacts.size();
    }


    /**
     * View holder
     */

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tvPhoneNumber;
        TextView tvPhoneData;
        ImageView ivPhoneType;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            tvPhoneData = (TextView) itemView.findViewById(R.id.tvPhoneData);
            ivPhoneType = (ImageView) itemView.findViewById(R.id.ivPhoneType);
        }
    }

}

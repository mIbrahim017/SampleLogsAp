package mohamedibrahim.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import mohamedibrahim.model.ContactModel;
import mohamedibrahim.sampleproject.Constants;
import mohamedibrahim.sampleproject.R;

/**
 * Created by Mohamed on 4/6/2015.
 */
public class MyListCursorAdapter extends CursorRecyclerViewAdapter<MyListCursorAdapter.ViewHolder> {

    private Cursor cursor;
    private Context context;


    public MyListCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.context = context;
        this.cursor = cursor;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {

        ContactModel contactModel = ContactModel.fromCursor(cursor);


        String date = getDate(contactModel.getsDate());
        viewHolder.ivPhoneType.setImageResource(getPhoneTypeResource(contactModel.getPhoneType()));
        viewHolder.tvPhoneData.setText(date);
        viewHolder.tvPhoneNumber.setText(contactModel.getPhoneNumber());


    }


    private String getDate(long date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd");
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return dateFormat.format(c.getTime());


    }


    private int getPhoneTypeResource(int phoneType) {

        switch (phoneType) {

            case CallLog.Calls.INCOMING_TYPE:
                return Constants.INCOMING;
            case CallLog.Calls.OUTGOING_TYPE:
                return Constants.OUT;
            case CallLog.Calls.MISSED_TYPE:
                return Constants.MISSED;


            default:
                return Constants.OUT;
        }


    }


    @Override
    public MyListCursorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhoneNumber;
        TextView tvPhoneData;
        ImageView ivPhoneType;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            tvPhoneData = (TextView) itemView.findViewById(R.id.tvPhoneData);
            ivPhoneType = (ImageView) itemView.findViewById(R.id.ivPhoneType);
        }
    }
}

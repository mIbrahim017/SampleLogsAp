package mohamedibrahim.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Mohamed on 4/6/2015.
 */
public abstract class CursorRecyclerViewAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private Context context; //  the context of the adapter
    private Cursor cursor; // the cursor
    private boolean mDataValid; // flag if cursor is valid when the cursor is changed or closed
    private int mRowIdColumn; // id for the each row in cursor
    private DataSetObserver mDataSetObserver; // observer to change the data if cursor is changed.


    public CursorRecyclerViewAdapter(Context context, Cursor cursor) {

        this.context = context;
        this.cursor = cursor;
        mDataValid = cursor != null;
        mRowIdColumn = mDataValid ? cursor.getColumnIndex("_id") : -1;
        mDataSetObserver = new NotifyingDataSetObserver();
        if (cursor != null) {
            cursor.registerDataSetObserver(mDataSetObserver);
        }

    }

    public Cursor getCursor() {
        return cursor;
    }

    @Override
    public int getItemCount() {
        if (mDataValid && cursor != null) {
            return cursor.getCount();
        }

        return 0;
    }

    @Override
    public long getItemId(int position) {

        if (mDataValid && cursor != null && cursor.moveToPosition(position)) {
            return cursor.getLong(mRowIdColumn);
        }

        return 0;
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(true);
    }

    public abstract void onBindViewHolder(VH viewHolder, Cursor cursor);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (!mDataValid)
            throw new IllegalStateException("this should only be called when the cursor is valid");

        if (!cursor.moveToPosition(position))
            throw new IllegalStateException("couldn't move cursor to position " + position);

        onBindViewHolder(holder, cursor);
    }


    /*
    change the cursor
     */

    public void changeCursor(Cursor cursor) {
        Cursor old = swapCursor(cursor);
        if (old != null)
            old.close();
    }

    private Cursor swapCursor(Cursor newCursor) {

        if (cursor == newCursor) return null;  // if same cursor do no thing

        final Cursor oldCursor = cursor;

        if (oldCursor != null && mDataSetObserver != null) {
            oldCursor.unregisterDataSetObserver(mDataSetObserver);
        }

        cursor = newCursor;
        if (cursor != null) {

            mDataValid = true;
            mRowIdColumn = cursor.getColumnIndex("_id");
            mDataSetObserver = new NotifyingDataSetObserver();
            if (mDataSetObserver != null) {
                cursor.registerDataSetObserver(mDataSetObserver);
            }

            notifyDataSetChanged();

        } else {
            mRowIdColumn = -1;
            mDataValid = false;
            notifyDataSetChanged();
        }

        return oldCursor; // return old cursor to close it

    }

    // implementation of te data ser changed observer

    private class NotifyingDataSetObserver extends DataSetObserver {

        @Override
        public void onChanged() {
            super.onChanged();
            mDataValid = true;
            notifyDataSetChanged();
        }

        @Override
        public void onInvalidated() {
            super.onInvalidated();
            // the cursor isn't valid or closed
            mDataValid = false;
            notifyDataSetChanged();
        }
    }


}

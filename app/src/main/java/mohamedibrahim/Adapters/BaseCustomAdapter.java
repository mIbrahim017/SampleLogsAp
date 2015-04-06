package mohamedibrahim.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Lenovo on 06/04/2015.
 */
public abstract class BaseCustomAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> list;

    public BaseCustomAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;


    }


    @Override
    public int getCount() {
        if (list == null) return 0;

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if (list == null) return null;
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract View onBindView(int position, View v, ViewGroup parent);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return onBindView(position, convertView, parent);
    }

    public void changeDataSet(List<T> newData) {
        if (newData == null)
            throw new IllegalStateException("Data Set must not be null");

        this.list = newData;
        notifyDataSetChanged();

    }
}

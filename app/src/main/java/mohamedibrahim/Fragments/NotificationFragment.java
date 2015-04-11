package mohamedibrahim.Fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import mohamedibrahim.sampleproject.R;

/**
 * Created by mohamed Ibrahim on 11/04/2015.
 */
public class NotificationFragment extends BaseFragment implements View.OnClickListener {


    private static final int NOTIFICATION_ID = 100512;
    // views
    private EditText edTitle;
    private EditText edMessage;
    private CheckBox cbAddActions;
    private Button btnCreate;


    // notification components
    NotificationCompat.Builder mNotificationBuilder;
    NotificationManager mNotificationManager;


    public NotificationFragment() {
        // required
    }

    public static NotificationFragment newInstance() {
        NotificationFragment notificationFragment = new NotificationFragment();
        return notificationFragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNotificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
    }


    private void onCreateNotification() {
        mNotificationBuilder = new NotificationCompat.Builder(getActivity());
        mNotificationBuilder.setContentTitle(edTitle.getText().toString());
        mNotificationBuilder.setContentText(edMessage.getText().toString());
        if (cbAddActions.isChecked()) {
            mNotificationBuilder.addAction(R.drawable.abc_ic_menu_share_mtrl_alpha, "Share", null);
        }
        mNotificationBuilder.setSmallIcon(android.R.drawable.ic_notification_clear_all);
        Notification notification = mNotificationBuilder.build();
        mNotificationManager.notify(NOTIFICATION_ID, notification);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.notification_fragment, container, false);
        injectViews(v);
        return v;
    }


    private void injectViews(View v) {
        edTitle = (EditText) v.findViewById(R.id.edTitle);
        edMessage = (EditText) v.findViewById(R.id.edMessage);
        cbAddActions = (CheckBox) v.findViewById(R.id.cbAddActions);
        btnCreate = (Button) v.findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public String getFragmentName() {
        return "Notifications";
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.btnCreate:
                onCreateNotification();

                break;
        }
    }
}

package mohamedibrahim.model;

import android.database.Cursor;
import android.provider.CallLog;

import java.util.Date;

/**
 * Created by Mohamed on 4/1/2015.
 */
public class ContactModel {

    private String phoneNumber;
    private Date callDate;
    private int phoneType;
    private long date;


    public ContactModel() {

    }

    public ContactModel(String phoneNumber, Date callDate, int phoneType) {
        this.phoneNumber = phoneNumber;
        this.callDate = callDate;
        this.phoneType = phoneType;
    }


    // setter & getter


    public void setsDate(long sDate) {
        this.date = sDate;
    }

    public long getsDate() {
        return date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public int getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(int phoneType) {
        this.phoneType = phoneType;
    }


    public static ContactModel fromCursor(Cursor c) {

        ContactModel contactModel = new ContactModel();
        String num = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));// for  number
        String name = c.getString(c.getColumnIndex(CallLog.Calls.CACHED_NAME));// for name
        String duration = c.getString(c.getColumnIndex(CallLog.Calls.DURATION));// for duration
        int type = Integer.parseInt(c.getString(c.getColumnIndex(CallLog.Calls.TYPE)));// type
        long date = c.getLong(c.getColumnIndex(CallLog.Calls.DATE));


        contactModel.setPhoneNumber(num);
        contactModel.setsDate(date);
        contactModel.setPhoneType(type);

        return contactModel;
    }
}

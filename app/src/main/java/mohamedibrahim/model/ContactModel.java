package mohamedibrahim.model;

import java.util.Date;

/**
 * Created by Mohamed on 4/1/2015.
 */
public class ContactModel {

    private String phoneNumber;
    private Date callDate;
    private int phoneType;


    public ContactModel() {

    }

    public ContactModel(String phoneNumber, Date callDate, int phoneType) {
        this.phoneNumber = phoneNumber;
        this.callDate = callDate;
        this.phoneType = phoneType;
    }


    // setter & getter

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


}

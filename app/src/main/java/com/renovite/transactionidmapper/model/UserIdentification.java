
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserIdentification implements Parcelable
{

    @SerializedName("isGuest")
    @Expose
    private Boolean isGuest;
    @SerializedName("retailerUserRef")
    @Expose
    private String retailerUserRef;
    public final static Creator<UserIdentification> CREATOR = new Creator<UserIdentification>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserIdentification createFromParcel(Parcel in) {
            return new UserIdentification(in);
        }

        public UserIdentification[] newArray(int size) {
            return (new UserIdentification[size]);
        }

    }
    ;

    protected UserIdentification(Parcel in) {
        this.isGuest = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.retailerUserRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserIdentification() {
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

    public String getRetailerUserRef() {
        return retailerUserRef;
    }

    public void setRetailerUserRef(String retailerUserRef) {
        this.retailerUserRef = retailerUserRef;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isGuest);
        dest.writeValue(retailerUserRef);
    }

    public int describeContents() {
        return  0;
    }

}


package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemReturn implements Parcelable
{

    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    public final static Creator<ItemReturn> CREATOR = new Creator<ItemReturn>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ItemReturn createFromParcel(Parcel in) {
            return new ItemReturn(in);
        }

        public ItemReturn[] newArray(int size) {
            return (new ItemReturn[size]);
        }

    }
    ;

    protected ItemReturn(Parcel in) {
        this.reason = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ItemReturn() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reason);
        dest.writeValue(timestamp);
    }

    public int describeContents() {
        return  0;
    }

}

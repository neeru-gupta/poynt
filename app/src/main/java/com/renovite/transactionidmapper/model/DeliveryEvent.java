
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryEvent implements Parcelable
{

    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    public final static Creator<DeliveryEvent> CREATOR = new Creator<DeliveryEvent>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DeliveryEvent createFromParcel(Parcel in) {
            return new DeliveryEvent(in);
        }

        public DeliveryEvent[] newArray(int size) {
            return (new DeliveryEvent[size]);
        }

    }
    ;

    protected DeliveryEvent(Parcel in) {
        this.reason = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DeliveryEvent() {
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

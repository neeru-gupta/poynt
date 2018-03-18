
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DeliveryEvent implements Serializable, Parcelable
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
    private final static long serialVersionUID = 2093549656601783207L;

    protected DeliveryEvent(Parcel in) {
        this.reason = ((String) in.readValue((String.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeliveryEvent() {
    }

    /**
     * 
     * @param timestamp
     * @param reason
     */
    public DeliveryEvent(String reason, String timestamp) {
        super();
        this.reason = reason;
        this.timestamp = timestamp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DeliveryEvent withReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public DeliveryEvent withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("reason", reason).append("timestamp", timestamp).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timestamp).append(reason).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DeliveryEvent) == false) {
            return false;
        }
        DeliveryEvent rhs = ((DeliveryEvent) other);
        return new EqualsBuilder().append(timestamp, rhs.timestamp).append(reason, rhs.reason).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reason);
        dest.writeValue(timestamp);
    }

    public int describeContents() {
        return  0;
    }

}

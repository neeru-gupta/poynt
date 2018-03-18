
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Delivery implements Serializable, Parcelable
{

    @SerializedName("counts")
    @Expose
    private List<Integer> counts = null;
    @SerializedName("deliveryEvents")
    @Expose
    private List<DeliveryEvent> deliveryEvents = null;
    public final static Creator<Delivery> CREATOR = new Creator<Delivery>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Delivery createFromParcel(Parcel in) {
            return new Delivery(in);
        }

        public Delivery[] newArray(int size) {
            return (new Delivery[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2650312557505475594L;

    protected Delivery(Parcel in) {
        in.readList(this.counts, (Integer.class.getClassLoader()));
        in.readList(this.deliveryEvents, (com.renovite.transactionidmapper.model.order.DeliveryEvent.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Delivery() {
    }

    /**
     * 
     * @param deliveryEvents
     * @param counts
     */
    public Delivery(List<Integer> counts, List<DeliveryEvent> deliveryEvents) {
        super();
        this.counts = counts;
        this.deliveryEvents = deliveryEvents;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public Delivery withCounts(List<Integer> counts) {
        this.counts = counts;
        return this;
    }

    public List<DeliveryEvent> getDeliveryEvents() {
        return deliveryEvents;
    }

    public void setDeliveryEvents(List<DeliveryEvent> deliveryEvents) {
        this.deliveryEvents = deliveryEvents;
    }

    public Delivery withDeliveryEvents(List<DeliveryEvent> deliveryEvents) {
        this.deliveryEvents = deliveryEvents;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("counts", counts).append("deliveryEvents", deliveryEvents).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deliveryEvents).append(counts).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Delivery) == false) {
            return false;
        }
        Delivery rhs = ((Delivery) other);
        return new EqualsBuilder().append(deliveryEvents, rhs.deliveryEvents).append(counts, rhs.counts).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(counts);
        dest.writeList(deliveryEvents);
    }

    public int describeContents() {
        return  0;
    }

}


package com.renovite.transactionidmapper.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delivery implements Parcelable
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

    protected Delivery(Parcel in) {
        in.readList(this.counts, (Integer.class.getClassLoader()));
        in.readList(this.deliveryEvents, (com.renovite.transactionidmapper.model.DeliveryEvent.class.getClassLoader()));
    }

    public Delivery() {
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public List<DeliveryEvent> getDeliveryEvents() {
        return deliveryEvents;
    }

    public void setDeliveryEvents(List<DeliveryEvent> deliveryEvents) {
        this.deliveryEvents = deliveryEvents;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(counts);
        dest.writeList(deliveryEvents);
    }

    public int describeContents() {
        return  0;
    }

}

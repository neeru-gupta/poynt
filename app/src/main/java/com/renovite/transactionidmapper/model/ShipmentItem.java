
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentItem implements Parcelable
{

    @SerializedName("orderItemRef")
    @Expose
    private String orderItemRef;
    @SerializedName("orderRef")
    @Expose
    private String orderRef;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    public final static Creator<ShipmentItem> CREATOR = new Creator<ShipmentItem>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ShipmentItem createFromParcel(Parcel in) {
            return new ShipmentItem(in);
        }

        public ShipmentItem[] newArray(int size) {
            return (new ShipmentItem[size]);
        }

    }
    ;

    protected ShipmentItem(Parcel in) {
        this.orderItemRef = ((String) in.readValue((String.class.getClassLoader())));
        this.orderRef = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public ShipmentItem() {
    }

    public String getOrderItemRef() {
        return orderItemRef;
    }

    public void setOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(orderItemRef);
        dest.writeValue(orderRef);
        dest.writeValue(quantity);
    }

    public int describeContents() {
        return  0;
    }

}

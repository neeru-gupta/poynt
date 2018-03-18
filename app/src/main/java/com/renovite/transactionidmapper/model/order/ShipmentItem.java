
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

public class ShipmentItem implements Serializable, Parcelable
{

    @SerializedName("orderItemRef")
    @Expose
    private String orderItemRef;
    @SerializedName("orderRef")
    @Expose
    private OrderRef_ orderRef;
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
    private final static long serialVersionUID = -4427074747875271579L;

    protected ShipmentItem(Parcel in) {
        this.orderItemRef = ((String) in.readValue((String.class.getClassLoader())));
        this.orderRef = ((OrderRef_) in.readValue((OrderRef_.class.getClassLoader())));
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ShipmentItem() {
    }

    /**
     * 
     * @param orderItemRef
     * @param orderRef
     * @param quantity
     */
    public ShipmentItem(String orderItemRef, OrderRef_ orderRef, Integer quantity) {
        super();
        this.orderItemRef = orderItemRef;
        this.orderRef = orderRef;
        this.quantity = quantity;
    }

    public String getOrderItemRef() {
        return orderItemRef;
    }

    public void setOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
    }

    public ShipmentItem withOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
        return this;
    }

    public OrderRef_ getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(OrderRef_ orderRef) {
        this.orderRef = orderRef;
    }

    public ShipmentItem withOrderRef(OrderRef_ orderRef) {
        this.orderRef = orderRef;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ShipmentItem withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("orderItemRef", orderItemRef).append("orderRef", orderRef).append("quantity", quantity).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(orderItemRef).append(orderRef).append(quantity).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShipmentItem) == false) {
            return false;
        }
        ShipmentItem rhs = ((ShipmentItem) other);
        return new EqualsBuilder().append(orderItemRef, rhs.orderItemRef).append(orderRef, rhs.orderRef).append(quantity, rhs.quantity).isEquals();
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

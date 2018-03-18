
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

public class RetailOrder implements Serializable, Parcelable
{

    @SerializedName("order")
    @Expose
    private Order order;
    public final static Creator<RetailOrder> CREATOR = new Creator<RetailOrder>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RetailOrder createFromParcel(Parcel in) {
            return new RetailOrder(in);
        }

        public RetailOrder[] newArray(int size) {
            return (new RetailOrder[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2807043369873665380L;

    protected RetailOrder(Parcel in) {
        this.order = ((Order) in.readValue((Order.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RetailOrder() {
    }

    /**
     * 
     * @param order
     */
    public RetailOrder(Order order) {
        super();
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public RetailOrder withOrder(Order order) {
        this.order = order;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("order", order).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(order).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RetailOrder) == false) {
            return false;
        }
        RetailOrder rhs = ((RetailOrder) other);
        return new EqualsBuilder().append(order, rhs.order).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(order);
    }

    public int describeContents() {
        return  0;
    }

}

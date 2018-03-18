
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

public class OrderRef implements Serializable, Parcelable
{

    @SerializedName("newOrderRef")
    @Expose
    private String newOrderRef;
    public final static Creator<OrderRef> CREATOR = new Creator<OrderRef>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OrderRef createFromParcel(Parcel in) {
            return new OrderRef(in);
        }

        public OrderRef[] newArray(int size) {
            return (new OrderRef[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8890758415692519161L;

    protected OrderRef(Parcel in) {
        this.newOrderRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderRef() {
    }

    /**
     * 
     * @param newOrderRef
     */
    public OrderRef(String newOrderRef) {
        super();
        this.newOrderRef = newOrderRef;
    }

    public String getNewOrderRef() {
        return newOrderRef;
    }

    public void setNewOrderRef(String newOrderRef) {
        this.newOrderRef = newOrderRef;
    }

    public OrderRef withNewOrderRef(String newOrderRef) {
        this.newOrderRef = newOrderRef;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("newOrderRef", newOrderRef).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(newOrderRef).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderRef) == false) {
            return false;
        }
        OrderRef rhs = ((OrderRef) other);
        return new EqualsBuilder().append(newOrderRef, rhs.newOrderRef).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(newOrderRef);
    }

    public int describeContents() {
        return  0;
    }

}

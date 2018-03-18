
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

public class OrderRef_ implements Serializable, Parcelable
{

    @SerializedName("newOrderRef")
    @Expose
    private String newOrderRef;
    public final static Creator<OrderRef_> CREATOR = new Creator<OrderRef_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OrderRef_ createFromParcel(Parcel in) {
            return new OrderRef_(in);
        }

        public OrderRef_[] newArray(int size) {
            return (new OrderRef_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2996176269661226288L;

    protected OrderRef_(Parcel in) {
        this.newOrderRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderRef_() {
    }

    /**
     * 
     * @param newOrderRef
     */
    public OrderRef_(String newOrderRef) {
        super();
        this.newOrderRef = newOrderRef;
    }

    public String getNewOrderRef() {
        return newOrderRef;
    }

    public void setNewOrderRef(String newOrderRef) {
        this.newOrderRef = newOrderRef;
    }

    public OrderRef_ withNewOrderRef(String newOrderRef) {
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
        if ((other instanceof OrderRef_) == false) {
            return false;
        }
        OrderRef_ rhs = ((OrderRef_) other);
        return new EqualsBuilder().append(newOrderRef, rhs.newOrderRef).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(newOrderRef);
    }

    public int describeContents() {
        return  0;
    }

}

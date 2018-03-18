
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

public class Quantity implements Serializable, Parcelable
{

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("units")
    @Expose
    private String units;
    public final static Creator<Quantity> CREATOR = new Creator<Quantity>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Quantity createFromParcel(Parcel in) {
            return new Quantity(in);
        }

        public Quantity[] newArray(int size) {
            return (new Quantity[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2283209956478038475L;

    protected Quantity(Parcel in) {
        this.quantity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.units = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quantity() {
    }

    /**
     * 
     * @param quantity
     * @param units
     */
    public Quantity(Integer quantity, String units) {
        super();
        this.quantity = quantity;
        this.units = units;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Quantity withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Quantity withUnits(String units) {
        this.units = units;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("quantity", quantity).append("units", units).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(quantity).append(units).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Quantity) == false) {
            return false;
        }
        Quantity rhs = ((Quantity) other);
        return new EqualsBuilder().append(quantity, rhs.quantity).append(units, rhs.units).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(quantity);
        dest.writeValue(units);
    }

    public int describeContents() {
        return  0;
    }

}

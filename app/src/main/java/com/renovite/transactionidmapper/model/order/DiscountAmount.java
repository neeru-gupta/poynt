
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

public class DiscountAmount implements Serializable, Parcelable
{

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    public final static Creator<DiscountAmount> CREATOR = new Creator<DiscountAmount>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DiscountAmount createFromParcel(Parcel in) {
            return new DiscountAmount(in);
        }

        public DiscountAmount[] newArray(int size) {
            return (new DiscountAmount[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7676491501231731074L;

    protected DiscountAmount(Parcel in) {
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public DiscountAmount() {
    }

    /**
     * 
     * @param quantity
     * @param currency
     */
    public DiscountAmount(String currency, Double quantity) {
        super();
        this.currency = currency;
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public DiscountAmount withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public DiscountAmount withQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("currency", currency).append("quantity", quantity).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(quantity).append(currency).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DiscountAmount) == false) {
            return false;
        }
        DiscountAmount rhs = ((DiscountAmount) other);
        return new EqualsBuilder().append(quantity, rhs.quantity).append(currency, rhs.currency).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(currency);
        dest.writeValue(quantity);
    }

    public int describeContents() {
        return  0;
    }

}

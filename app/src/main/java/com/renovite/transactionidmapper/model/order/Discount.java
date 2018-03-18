
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

public class Discount implements Serializable, Parcelable
{

    @SerializedName("discountAmount")
    @Expose
    private DiscountAmount discountAmount;
    @SerializedName("discountName")
    @Expose
    private String discountName;
    public final static Creator<Discount> CREATOR = new Creator<Discount>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Discount createFromParcel(Parcel in) {
            return new Discount(in);
        }

        public Discount[] newArray(int size) {
            return (new Discount[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5514083126174718868L;

    protected Discount(Parcel in) {
        this.discountAmount = ((DiscountAmount) in.readValue((DiscountAmount.class.getClassLoader())));
        this.discountName = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Discount() {
    }

    /**
     * 
     * @param discountName
     * @param discountAmount
     */
    public Discount(DiscountAmount discountAmount, String discountName) {
        super();
        this.discountAmount = discountAmount;
        this.discountName = discountName;
    }

    public DiscountAmount getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Discount withDiscountAmount(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Discount withDiscountName(String discountName) {
        this.discountName = discountName;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("discountAmount", discountAmount).append("discountName", discountName).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(discountName).append(discountAmount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Discount) == false) {
            return false;
        }
        Discount rhs = ((Discount) other);
        return new EqualsBuilder().append(discountName, rhs.discountName).append(discountAmount, rhs.discountAmount).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(discountAmount);
        dest.writeValue(discountName);
    }

    public int describeContents() {
        return  0;
    }

}

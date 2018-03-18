
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

public class ItemDiscount implements Serializable, Parcelable
{

    @SerializedName("discountAmount")
    @Expose
    private DiscountAmount_ discountAmount;
    @SerializedName("discountName")
    @Expose
    private String discountName;
    public final static Creator<ItemDiscount> CREATOR = new Creator<ItemDiscount>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ItemDiscount createFromParcel(Parcel in) {
            return new ItemDiscount(in);
        }

        public ItemDiscount[] newArray(int size) {
            return (new ItemDiscount[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3167757366764964998L;

    protected ItemDiscount(Parcel in) {
        this.discountAmount = ((DiscountAmount_) in.readValue((DiscountAmount_.class.getClassLoader())));
        this.discountName = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemDiscount() {
    }

    /**
     * 
     * @param discountName
     * @param discountAmount
     */
    public ItemDiscount(DiscountAmount_ discountAmount, String discountName) {
        super();
        this.discountAmount = discountAmount;
        this.discountName = discountName;
    }

    public DiscountAmount_ getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(DiscountAmount_ discountAmount) {
        this.discountAmount = discountAmount;
    }

    public ItemDiscount withDiscountAmount(DiscountAmount_ discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public ItemDiscount withDiscountName(String discountName) {
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
        if ((other instanceof ItemDiscount) == false) {
            return false;
        }
        ItemDiscount rhs = ((ItemDiscount) other);
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

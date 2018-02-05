
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Discount implements Parcelable
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

    protected Discount(Parcel in) {
        this.discountAmount = ((DiscountAmount) in.readValue((DiscountAmount.class.getClassLoader())));
        this.discountName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Discount() {
    }

    public DiscountAmount getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(discountAmount);
        dest.writeValue(discountName);
    }

    public int describeContents() {
        return  0;
    }

}

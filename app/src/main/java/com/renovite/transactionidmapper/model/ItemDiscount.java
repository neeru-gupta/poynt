
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDiscount implements Parcelable
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

    protected ItemDiscount(Parcel in) {
        this.discountAmount = ((DiscountAmount_) in.readValue((DiscountAmount_.class.getClassLoader())));
        this.discountName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ItemDiscount() {
    }

    public DiscountAmount_ getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(DiscountAmount_ discountAmount) {
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

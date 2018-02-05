
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class SubTotal implements Parcelable
{

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("quantity")
    @Expose
    private BigDecimal quantity;
    public final static Creator<SubTotal> CREATOR = new Creator<SubTotal>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SubTotal createFromParcel(Parcel in) {
            return new SubTotal(in);
        }

        public SubTotal[] newArray(int size) {
            return (new SubTotal[size]);
        }

    }
    ;

    protected SubTotal(Parcel in) {
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((BigDecimal) in.readValue((Double.class.getClassLoader())));
    }

    public SubTotal() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(currency);
        dest.writeValue(quantity);
    }

    public int describeContents() {
        return  0;
    }

}

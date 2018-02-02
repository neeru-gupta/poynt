
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class PaymentMethod_Amount implements Parcelable
{

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("quantity")
    @Expose
    private BigDecimal quantity;
    public final static Creator<PaymentMethod_Amount> CREATOR = new Creator<PaymentMethod_Amount>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PaymentMethod_Amount createFromParcel(Parcel in) {
            return new PaymentMethod_Amount(in);
        }

        public PaymentMethod_Amount[] newArray(int size) {
            return (new PaymentMethod_Amount[size]);
        }

    }
    ;

    protected PaymentMethod_Amount(Parcel in) {
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((BigDecimal) in.readValue((Double.class.getClassLoader())));
    }

    public PaymentMethod_Amount() {
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

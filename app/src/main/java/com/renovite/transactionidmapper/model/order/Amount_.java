
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Amount_ implements Serializable, Parcelable
{

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    public final static Creator<Amount_> CREATOR = new Creator<Amount_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Amount_ createFromParcel(Parcel in) {
            return new Amount_(in);
        }

        public Amount_[] newArray(int size) {
            return (new Amount_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 529893095829772716L;

    protected Amount_(Parcel in) {
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Amount_() {
    }

    /**
     * 
     * @param quantity
     * @param currency
     */
    public Amount_(String currency, Double quantity) {
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

    public Amount_ withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Amount_ withQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(currency);
        dest.writeValue(quantity);
    }

    public int describeContents() {
        return  0;
    }

}

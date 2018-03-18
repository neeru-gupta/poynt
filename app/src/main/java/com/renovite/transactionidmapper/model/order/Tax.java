
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax implements Serializable, Parcelable
{

    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("taxType")
    @Expose
    private String taxType;
    public final static Creator<Tax> CREATOR = new Creator<Tax>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tax createFromParcel(Parcel in) {
            return new Tax(in);
        }

        public Tax[] newArray(int size) {
            return (new Tax[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3838360315035407367L;

    protected Tax(Parcel in) {
        this.amount = ((Amount) in.readValue((Amount.class.getClassLoader())));
        this.rate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.taxType = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tax() {
    }

    /**
     * 
     * @param amount
     * @param rate
     * @param taxType
     */
    public Tax(Amount amount, Double rate, String taxType) {
        super();
        this.amount = amount;
        this.rate = rate;
        this.taxType = taxType;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Tax withAmount(Amount amount) {
        this.amount = amount;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Tax withRate(Double rate) {
        this.rate = rate;
        return this;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public Tax withTaxType(String taxType) {
        this.taxType = taxType;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(rate);
        dest.writeValue(taxType);
    }

    public int describeContents() {
        return  0;
    }

}

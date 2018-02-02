
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax implements Parcelable {

    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("rate")
    @Expose
    private Float rate;
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

    };

    protected Tax(Parcel in) {
        this.amount = ((Amount) in.readValue((Amount.class.getClassLoader())));
        this.rate = ((Float) in.readValue((Long.class.getClassLoader())));
        this.taxType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Tax() {
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(rate);
        dest.writeValue(taxType);
    }

    public int describeContents() {
        return 0;
    }

}

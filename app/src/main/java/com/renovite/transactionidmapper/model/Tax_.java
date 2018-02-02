
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tax_ implements Parcelable
{

    @SerializedName("amount")
    @Expose
    private Amount__ amount;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("taxType")
    @Expose
    private String taxType;
    public final static Creator<Tax_> CREATOR = new Creator<Tax_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tax_ createFromParcel(Parcel in) {
            return new Tax_(in);
        }

        public Tax_[] newArray(int size) {
            return (new Tax_[size]);
        }

    }
    ;

    protected Tax_(Parcel in) {
        this.amount = ((Amount__) in.readValue((Amount__.class.getClassLoader())));
        this.rate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.taxType = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Tax_() {
    }

    public Amount__ getAmount() {
        return amount;
    }

    public void setAmount(Amount__ amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
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
        return  0;
    }

}

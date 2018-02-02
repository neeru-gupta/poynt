
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Total_ implements Parcelable
{

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("quantity")
    @Expose
    private BigDecimal quantity;
    public final static Creator<Total_> CREATOR = new Creator<Total_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Total_ createFromParcel(Parcel in) {
            return new Total_(in);
        }

        public Total_[] newArray(int size) {
            return (new Total_[size]);
        }

    }
    ;

    protected Total_(Parcel in) {
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((BigDecimal) in.readValue((Double.class.getClassLoader())));
    }

    public Total_() {
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


package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quantity implements Parcelable
{

    @SerializedName("quantity")
    @Expose
    private Float quantity;
    @SerializedName("units")
    @Expose
    private String units;
    public final static Creator<Quantity> CREATOR = new Creator<Quantity>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Quantity createFromParcel(Parcel in) {
            return new Quantity(in);
        }

        public Quantity[] newArray(int size) {
            return (new Quantity[size]);
        }

    }
    ;

    protected Quantity(Parcel in) {
        this.quantity = ((Float) in.readValue((Float.class.getClassLoader())));
        this.units = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Quantity() {
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(quantity);
        dest.writeValue(units);
    }

    public int describeContents() {
        return  0;
    }

}

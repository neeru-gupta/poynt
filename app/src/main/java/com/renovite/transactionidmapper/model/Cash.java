
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cash implements Parcelable
{

    @SerializedName("purchaseOrderNumber")
    @Expose
    private String purchaseOrderNumber;
    public final static Creator<Cash> CREATOR = new Creator<Cash>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Cash createFromParcel(Parcel in) {
            return new Cash(in);
        }

        public Cash[] newArray(int size) {
            return (new Cash[size]);
        }

    }
    ;

    protected Cash(Parcel in) {
        this.purchaseOrderNumber = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Cash() {
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(purchaseOrderNumber);
    }

    public int describeContents() {
        return  0;
    }

}

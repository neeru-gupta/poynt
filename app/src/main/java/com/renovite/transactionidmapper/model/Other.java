
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Other implements Parcelable
{

    @SerializedName("purchaseOrderNumber")
    @Expose
    private String purchaseOrderNumber;
    public final static Creator<Other> CREATOR = new Creator<Other>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Other createFromParcel(Parcel in) {
            return new Other(in);
        }

        public Other[] newArray(int size) {
            return (new Other[size]);
        }

    }
    ;

    protected Other(Parcel in) {
        this.purchaseOrderNumber = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Other() {
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

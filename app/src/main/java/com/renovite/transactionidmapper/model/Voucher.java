
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Voucher implements Parcelable
{

    @SerializedName("purchaseOrderNumber")
    @Expose
    private String purchaseOrderNumber;
    public final static Creator<Voucher> CREATOR = new Creator<Voucher>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Voucher createFromParcel(Parcel in) {
            return new Voucher(in);
        }

        public Voucher[] newArray(int size) {
            return (new Voucher[size]);
        }

    }
    ;

    protected Voucher(Parcel in) {
        this.purchaseOrderNumber = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Voucher() {
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

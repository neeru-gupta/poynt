
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Voucher implements Serializable, Parcelable
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
    private final static long serialVersionUID = 1960384309112179659L;

    protected Voucher(Parcel in) {
        this.purchaseOrderNumber = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Voucher() {
    }

    /**
     * 
     * @param purchaseOrderNumber
     */
    public Voucher(String purchaseOrderNumber) {
        super();
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Voucher withPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("purchaseOrderNumber", purchaseOrderNumber).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(purchaseOrderNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Voucher) == false) {
            return false;
        }
        Voucher rhs = ((Voucher) other);
        return new EqualsBuilder().append(purchaseOrderNumber, rhs.purchaseOrderNumber).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(purchaseOrderNumber);
    }

    public int describeContents() {
        return  0;
    }

}


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

public class Tax_ implements Serializable, Parcelable
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
    private final static long serialVersionUID = 5474579742801227183L;

    protected Tax_(Parcel in) {
        this.amount = ((Amount__) in.readValue((Amount__.class.getClassLoader())));
        this.rate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.taxType = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tax_() {
    }

    /**
     * 
     * @param amount
     * @param rate
     * @param taxType
     */
    public Tax_(Amount__ amount, Double rate, String taxType) {
        super();
        this.amount = amount;
        this.rate = rate;
        this.taxType = taxType;
    }

    public Amount__ getAmount() {
        return amount;
    }

    public void setAmount(Amount__ amount) {
        this.amount = amount;
    }

    public Tax_ withAmount(Amount__ amount) {
        this.amount = amount;
        return this;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Tax_ withRate(Double rate) {
        this.rate = rate;
        return this;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public Tax_ withTaxType(String taxType) {
        this.taxType = taxType;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("amount", amount).append("rate", rate).append("taxType", taxType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(rate).append(taxType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tax_) == false) {
            return false;
        }
        Tax_ rhs = ((Tax_) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(rate, rhs.rate).append(taxType, rhs.taxType).isEquals();
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

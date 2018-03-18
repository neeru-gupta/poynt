
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

public class PaymentMethod implements Serializable, Parcelable
{

    @SerializedName("amount")
    @Expose
    private Amount_ amount;
    @SerializedName("card")
    @Expose
    private Card card;
    @SerializedName("paymentMethod")
    @Expose
    private String paymentMethod;
    @SerializedName("paymentMethodType")
    @Expose
    private String paymentMethodType;
    @SerializedName("voucher")
    @Expose
    private Voucher voucher;
    public final static Creator<PaymentMethod> CREATOR = new Creator<PaymentMethod>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PaymentMethod createFromParcel(Parcel in) {
            return new PaymentMethod(in);
        }

        public PaymentMethod[] newArray(int size) {
            return (new PaymentMethod[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7782695631356269173L;

    protected PaymentMethod(Parcel in) {
        this.amount = ((Amount_) in.readValue((Amount_.class.getClassLoader())));
        this.card = ((Card) in.readValue((Card.class.getClassLoader())));
        this.paymentMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentMethodType = ((String) in.readValue((String.class.getClassLoader())));
        this.voucher = ((Voucher) in.readValue((Voucher.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentMethod() {
    }

    /**
     * 
     * @param amount
     * @param card
     * @param voucher
     * @param paymentMethodType
     * @param paymentMethod
     */
    public PaymentMethod(Amount_ amount, Card card, String paymentMethod, String paymentMethodType, Voucher voucher) {
        super();
        this.amount = amount;
        this.card = card;
        this.paymentMethod = paymentMethod;
        this.paymentMethodType = paymentMethodType;
        this.voucher = voucher;
    }

    public Amount_ getAmount() {
        return amount;
    }

    public void setAmount(Amount_ amount) {
        this.amount = amount;
    }

    public PaymentMethod withAmount(Amount_ amount) {
        this.amount = amount;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public PaymentMethod withCard(Card card) {
        this.card = card;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public PaymentMethod withPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
        return this;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public PaymentMethod withVoucher(Voucher voucher) {
        this.voucher = voucher;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("amount", amount).append("card", card).append("paymentMethod", paymentMethod).append("paymentMethodType", paymentMethodType).append("voucher", voucher).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(amount).append(card).append(voucher).append(paymentMethodType).append(paymentMethod).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentMethod) == false) {
            return false;
        }
        PaymentMethod rhs = ((PaymentMethod) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(card, rhs.card).append(voucher, rhs.voucher).append(paymentMethodType, rhs.paymentMethodType).append(paymentMethod, rhs.paymentMethod).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(card);
        dest.writeValue(paymentMethod);
        dest.writeValue(paymentMethodType);
        dest.writeValue(voucher);
    }

    public int describeContents() {
        return  0;
    }

}

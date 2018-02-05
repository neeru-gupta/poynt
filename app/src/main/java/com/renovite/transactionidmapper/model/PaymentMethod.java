
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentMethod implements Parcelable
{

    @SerializedName("amount")
    @Expose
    private PaymentMethod_Amount amount;
    @SerializedName("card")
    @Expose
    private Card card;
    @SerializedName("cash")
    @Expose
    private Cash cash;
    @SerializedName("other")
    @Expose
    private Other other;
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

    protected PaymentMethod(Parcel in) {
        this.amount = ((PaymentMethod_Amount) in.readValue((PaymentMethod_Amount.class.getClassLoader())));
        this.card = ((Card) in.readValue((Card.class.getClassLoader())));
        this.cash = ((Cash) in.readValue((Cash.class.getClassLoader())));
        this.other = ((Other) in.readValue((Other.class.getClassLoader())));
        this.paymentMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentMethodType = ((String) in.readValue((String.class.getClassLoader())));
        this.voucher = ((Voucher) in.readValue((Voucher.class.getClassLoader())));
    }

    public PaymentMethod() {
    }

    public PaymentMethod_Amount getAmount() {
        return amount;
    }

    public void setAmount(PaymentMethod_Amount amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(card);
        dest.writeValue(cash);
        dest.writeValue(other);
        dest.writeValue(paymentMethod);
        dest.writeValue(paymentMethodType);
        dest.writeValue(voucher);
    }

    public int describeContents() {
        return  0;
    }

}

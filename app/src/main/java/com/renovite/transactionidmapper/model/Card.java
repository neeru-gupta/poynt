
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card implements Parcelable
{

    @SerializedName("authCode")
    @Expose
    private String authCode;
    @SerializedName("cardType")
    @Expose
    private String cardType;
    @SerializedName("expirationDate")
    @Expose
    private String expirationDate;
    @SerializedName("issuer")
    @Expose
    private String issuer;
    @SerializedName("lastFour")
    @Expose
    private String lastFour;
    @SerializedName("paymentNetworkToken")
    @Expose
    private String paymentNetworkToken;
    @SerializedName("purchaseOrderNumber")
    @Expose
    private String purchaseOrderNumber;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    public final static Creator<Card> CREATOR = new Creator<Card>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        public Card[] newArray(int size) {
            return (new Card[size]);
        }

    }
    ;

    protected Card(Parcel in) {
        this.authCode = ((String) in.readValue((String.class.getClassLoader())));
        this.cardType = ((String) in.readValue((String.class.getClassLoader())));
        this.expirationDate = ((String) in.readValue((String.class.getClassLoader())));
        this.issuer = ((String) in.readValue((String.class.getClassLoader())));
        this.lastFour = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentNetworkToken = ((String) in.readValue((String.class.getClassLoader())));
        this.purchaseOrderNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Card() {
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public String getPaymentNetworkToken() {
        return paymentNetworkToken;
    }

    public void setPaymentNetworkToken(String paymentNetworkToken) {
        this.paymentNetworkToken = paymentNetworkToken;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(authCode);
        dest.writeValue(cardType);
        dest.writeValue(expirationDate);
        dest.writeValue(issuer);
        dest.writeValue(lastFour);
        dest.writeValue(paymentNetworkToken);
        dest.writeValue(purchaseOrderNumber);
        dest.writeValue(startDate);
    }

    public int describeContents() {
        return  0;
    }

}

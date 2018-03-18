
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

public class Card implements Serializable, Parcelable
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
    private final static long serialVersionUID = 7575454832882987065L;

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

    /**
     * No args constructor for use in serialization
     * 
     */
    public Card() {
    }

    /**
     * 
     * @param startDate
     * @param authCode
     * @param purchaseOrderNumber
     * @param expirationDate
     * @param issuer
     * @param paymentNetworkToken
     * @param lastFour
     * @param cardType
     */
    public Card(String authCode, String cardType, String expirationDate, String issuer, String lastFour, String paymentNetworkToken, String purchaseOrderNumber, String startDate) {
        super();
        this.authCode = authCode;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
        this.issuer = issuer;
        this.lastFour = lastFour;
        this.paymentNetworkToken = paymentNetworkToken;
        this.purchaseOrderNumber = purchaseOrderNumber;
        this.startDate = startDate;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Card withAuthCode(String authCode) {
        this.authCode = authCode;
        return this;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Card withCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Card withExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Card withIssuer(String issuer) {
        this.issuer = issuer;
        return this;
    }

    public String getLastFour() {
        return lastFour;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public Card withLastFour(String lastFour) {
        this.lastFour = lastFour;
        return this;
    }

    public String getPaymentNetworkToken() {
        return paymentNetworkToken;
    }

    public void setPaymentNetworkToken(String paymentNetworkToken) {
        this.paymentNetworkToken = paymentNetworkToken;
    }

    public Card withPaymentNetworkToken(String paymentNetworkToken) {
        this.paymentNetworkToken = paymentNetworkToken;
        return this;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public Card withPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Card withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("authCode", authCode).append("cardType", cardType).append("expirationDate", expirationDate).append("issuer", issuer).append("lastFour", lastFour).append("paymentNetworkToken", paymentNetworkToken).append("purchaseOrderNumber", purchaseOrderNumber).append("startDate", startDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(startDate).append(authCode).append(purchaseOrderNumber).append(expirationDate).append(issuer).append(paymentNetworkToken).append(lastFour).append(cardType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Card) == false) {
            return false;
        }
        Card rhs = ((Card) other);
        return new EqualsBuilder().append(startDate, rhs.startDate).append(authCode, rhs.authCode).append(purchaseOrderNumber, rhs.purchaseOrderNumber).append(expirationDate, rhs.expirationDate).append(issuer, rhs.issuer).append(paymentNetworkToken, rhs.paymentNetworkToken).append(lastFour, rhs.lastFour).append(cardType, rhs.cardType).isEquals();
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

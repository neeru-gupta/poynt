
package com.renovite.transactionidmapper.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order implements Parcelable
{

    @SerializedName("billingAddress")
    @Expose
    private BillingAddress billingAddress;
    @SerializedName("confirmationNumber")
    @Expose
    private String confirmationNumber;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("delivery")
    @Expose
    private Delivery delivery;
    @SerializedName("discounts")
    @Expose
    private List<Discount> discounts = null;
    @SerializedName("isGift")
    @Expose
    private Boolean isGift;
    @SerializedName("localization")
    @Expose
    private Localization localization;
    @SerializedName("optins")
    @Expose
    private List<Optin> optins = null;
    @SerializedName("orderDate")
    @Expose
    private String orderDate;
    @SerializedName("orderItems")
    @Expose
    private List<OrderItem> orderItems = null;
    @SerializedName("orderProperties")
    @Expose
    private OrderProperties orderProperties;
    @SerializedName("orderRef")
    @Expose
    private String orderRef;
    @SerializedName("orderType")
    @Expose
    private String orderType;
    @SerializedName("paymentMethods")
    @Expose
    private List<PaymentMethod> paymentMethods = null;
    @SerializedName("shipment")
    @Expose
    private Shipment shipment;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("store")
    @Expose
    private Store store;
    @SerializedName("subTotal")
    @Expose
    private SubTotal subTotal;
    @SerializedName("taxes")
    @Expose
    private List<Tax_> taxes = null;
    @SerializedName("total")
    @Expose
    private Total_ total;
    @SerializedName("userIdentification")
    @Expose
    private UserIdentification userIdentification;
    public final static Creator<Order> CREATOR = new Creator<Order>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        public Order[] newArray(int size) {
            return (new Order[size]);
        }

    }
    ;

    protected Order(Parcel in) {
        this.billingAddress = ((BillingAddress) in.readValue((BillingAddress.class.getClassLoader())));
        this.confirmationNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.customer = ((Customer) in.readValue((Customer.class.getClassLoader())));
        this.delivery = ((Delivery) in.readValue((Delivery.class.getClassLoader())));
        in.readList(this.discounts, (Discount.class.getClassLoader()));
        this.isGift = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.localization = ((Localization) in.readValue((Localization.class.getClassLoader())));
        in.readList(this.optins, (Optin.class.getClassLoader()));
        this.orderDate = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.orderItems, (com.renovite.transactionidmapper.model.OrderItem.class.getClassLoader()));
        this.orderProperties = ((OrderProperties) in.readValue((OrderProperties.class.getClassLoader())));
        this.orderRef = ((String) in.readValue((String.class.getClassLoader())));
        this.orderType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.paymentMethods, (com.renovite.transactionidmapper.model.PaymentMethod.class.getClassLoader()));
        this.shipment = ((Shipment) in.readValue((Shipment.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.store = ((Store) in.readValue((Store.class.getClassLoader())));
        this.subTotal = ((SubTotal) in.readValue((SubTotal.class.getClassLoader())));
        in.readList(this.taxes, (com.renovite.transactionidmapper.model.Tax_.class.getClassLoader()));
        this.total = ((Total_) in.readValue((Total_.class.getClassLoader())));
        this.userIdentification = ((UserIdentification) in.readValue((UserIdentification.class.getClassLoader())));
    }

    public Order() {
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public List<Optin> getOptins() {
        return optins;
    }

    public void setOptins(List<Optin> optins) {
        this.optins = optins;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderProperties getOrderProperties() {
        return orderProperties;
    }

    public void setOrderProperties(OrderProperties orderProperties) {
        this.orderProperties = orderProperties;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public SubTotal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(SubTotal subTotal) {
        this.subTotal = subTotal;
    }

    public List<Tax_> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax_> taxes) {
        this.taxes = taxes;
    }

    public Total_ getTotal() {
        return total;
    }

    public void setTotal(Total_ total) {
        this.total = total;
    }

    public UserIdentification getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(UserIdentification userIdentification) {
        this.userIdentification = userIdentification;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(billingAddress);
        dest.writeValue(confirmationNumber);
        dest.writeValue(customer);
        dest.writeValue(delivery);
        dest.writeList(discounts);
        dest.writeValue(isGift);
        dest.writeValue(localization);
        dest.writeList(optins);
        dest.writeValue(orderDate);
        dest.writeList(orderItems);
        dest.writeValue(orderProperties);
        dest.writeValue(orderRef);
        dest.writeValue(orderType);
        dest.writeList(paymentMethods);
        dest.writeValue(shipment);
        dest.writeValue(status);
        dest.writeValue(store);
        dest.writeValue(subTotal);
        dest.writeList(taxes);
        dest.writeValue(total);
        dest.writeValue(userIdentification);
    }

    public int describeContents() {
        return  0;
    }

}

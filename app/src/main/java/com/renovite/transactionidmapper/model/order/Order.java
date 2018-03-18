
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Order implements Serializable, Parcelable
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
    private OrderRef orderRef;
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
    private final static long serialVersionUID = 6836047695016233762L;

    protected Order(Parcel in) {
        this.billingAddress = ((BillingAddress) in.readValue((BillingAddress.class.getClassLoader())));
        this.confirmationNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.customer = ((Customer) in.readValue((Customer.class.getClassLoader())));
        this.delivery = ((Delivery) in.readValue((Delivery.class.getClassLoader())));
        in.readList(this.discounts, (com.renovite.transactionidmapper.model.order.Discount.class.getClassLoader()));
        this.isGift = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.localization = ((Localization) in.readValue((Localization.class.getClassLoader())));
        this.orderDate = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.orderItems, (com.renovite.transactionidmapper.model.order.OrderItem.class.getClassLoader()));
        this.orderProperties = ((OrderProperties) in.readValue((OrderProperties.class.getClassLoader())));
        this.orderRef = ((OrderRef) in.readValue((OrderRef.class.getClassLoader())));
        this.orderType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.paymentMethods, (com.renovite.transactionidmapper.model.order.PaymentMethod.class.getClassLoader()));
        this.shipment = ((Shipment) in.readValue((Shipment.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.store = ((Store) in.readValue((Store.class.getClassLoader())));
        this.subTotal = ((SubTotal) in.readValue((SubTotal.class.getClassLoader())));
        in.readList(this.taxes, (Tax_.class.getClassLoader()));
        this.total = ((Total_) in.readValue((Total_.class.getClassLoader())));
        this.userIdentification = ((UserIdentification) in.readValue((UserIdentification.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Order() {
    }

    /**
     * 
     * @param total
     * @param store
     * @param localization
     * @param status
     * @param orderType
     * @param orderDate
     * @param shipment
     * @param confirmationNumber
     * @param orderItems
     * @param customer
     * @param orderProperties
     * @param isGift
     * @param subTotal
     * @param discounts
     * @param paymentMethods
     * @param orderRef
     * @param billingAddress
     * @param delivery
     * @param userIdentification
     * @param taxes
     */
    public Order(BillingAddress billingAddress, String confirmationNumber, Customer customer, Delivery delivery, List<Discount> discounts, Boolean isGift, Localization localization, String orderDate, List<OrderItem> orderItems, OrderProperties orderProperties, OrderRef orderRef, String orderType, List<PaymentMethod> paymentMethods, Shipment shipment, String status, Store store, SubTotal subTotal, List<Tax_> taxes, Total_ total, UserIdentification userIdentification) {
        super();
        this.billingAddress = billingAddress;
        this.confirmationNumber = confirmationNumber;
        this.customer = customer;
        this.delivery = delivery;
        this.discounts = discounts;
        this.isGift = isGift;
        this.localization = localization;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.orderProperties = orderProperties;
        this.orderRef = orderRef;
        this.orderType = orderType;
        this.paymentMethods = paymentMethods;
        this.shipment = shipment;
        this.status = status;
        this.store = store;
        this.subTotal = subTotal;
        this.taxes = taxes;
        this.total = total;
        this.userIdentification = userIdentification;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Order withBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Order withConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Order withDelivery(Delivery delivery) {
        this.delivery = delivery;
        return this;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Order withDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
        return this;
    }

    public Boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    public Order withIsGift(Boolean isGift) {
        this.isGift = isGift;
        return this;
    }

    public Localization getLocalization() {
        return localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public Order withLocalization(Localization localization) {
        this.localization = localization;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Order withOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order withOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    public OrderProperties getOrderProperties() {
        return orderProperties;
    }

    public void setOrderProperties(OrderProperties orderProperties) {
        this.orderProperties = orderProperties;
    }

    public Order withOrderProperties(OrderProperties orderProperties) {
        this.orderProperties = orderProperties;
        return this;
    }

    public OrderRef getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(OrderRef orderRef) {
        this.orderRef = orderRef;
    }

    public Order withOrderRef(OrderRef orderRef) {
        this.orderRef = orderRef;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Order withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Order withPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
        return this;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Order withShipment(Shipment shipment) {
        this.shipment = shipment;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order withStatus(String status) {
        this.status = status;
        return this;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Order withStore(Store store) {
        this.store = store;
        return this;
    }

    public SubTotal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(SubTotal subTotal) {
        this.subTotal = subTotal;
    }

    public Order withSubTotal(SubTotal subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    public List<Tax_> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax_> taxes) {
        this.taxes = taxes;
    }

    public Order withTaxes(List<Tax_> taxes) {
        this.taxes = taxes;
        return this;
    }

    public Total_ getTotal() {
        return total;
    }

    public void setTotal(Total_ total) {
        this.total = total;
    }

    public Order withTotal(Total_ total) {
        this.total = total;
        return this;
    }

    public UserIdentification getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(UserIdentification userIdentification) {
        this.userIdentification = userIdentification;
    }

    public Order withUserIdentification(UserIdentification userIdentification) {
        this.userIdentification = userIdentification;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("billingAddress", billingAddress).append("confirmationNumber", confirmationNumber).append("customer", customer).append("delivery", delivery).append("discounts", discounts).append("isGift", isGift).append("localization", localization).append("orderDate", orderDate).append("orderItems", orderItems).append("orderProperties", orderProperties).append("orderRef", orderRef).append("orderType", orderType).append("paymentMethods", paymentMethods).append("shipment", shipment).append("status", status).append("store", store).append("subTotal", subTotal).append("taxes", taxes).append("total", total).append("userIdentification", userIdentification).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(store).append(localization).append(status).append(orderType).append(orderDate).append(shipment).append(confirmationNumber).append(orderItems).append(customer).append(orderProperties).append(isGift).append(subTotal).append(discounts).append(paymentMethods).append(orderRef).append(billingAddress).append(delivery).append(userIdentification).append(taxes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Order) == false) {
            return false;
        }
        Order rhs = ((Order) other);
        return new EqualsBuilder().append(total, rhs.total).append(store, rhs.store).append(localization, rhs.localization).append(status, rhs.status).append(orderType, rhs.orderType).append(orderDate, rhs.orderDate).append(shipment, rhs.shipment).append(confirmationNumber, rhs.confirmationNumber).append(orderItems, rhs.orderItems).append(customer, rhs.customer).append(orderProperties, rhs.orderProperties).append(isGift, rhs.isGift).append(subTotal, rhs.subTotal).append(discounts, rhs.discounts).append(paymentMethods, rhs.paymentMethods).append(orderRef, rhs.orderRef).append(billingAddress, rhs.billingAddress).append(delivery, rhs.delivery).append(userIdentification, rhs.userIdentification).append(taxes, rhs.taxes).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(billingAddress);
        dest.writeValue(confirmationNumber);
        dest.writeValue(customer);
        dest.writeValue(delivery);
        dest.writeList(discounts);
        dest.writeValue(isGift);
        dest.writeValue(localization);
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

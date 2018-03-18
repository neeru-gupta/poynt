
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

public class OrderItem implements Serializable, Parcelable
{

    @SerializedName("itemDiscounts")
    @Expose
    private List<ItemDiscount> itemDiscounts = null;
    @SerializedName("itemReturn")
    @Expose
    private ItemReturn itemReturn;
    @SerializedName("orderItemProperties")
    @Expose
    private List<String> orderItemProperties = null;
    @SerializedName("orderItemRef")
    @Expose
    private String orderItemRef;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("quantity")
    @Expose
    private Quantity quantity;
    @SerializedName("taxes")
    @Expose
    private List<Tax> taxes = null;
    @SerializedName("total")
    @Expose
    private Total total;
    @SerializedName("unitAmount")
    @Expose
    private UnitAmount unitAmount;
    public final static Creator<OrderItem> CREATOR = new Creator<OrderItem>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OrderItem createFromParcel(Parcel in) {
            return new OrderItem(in);
        }

        public OrderItem[] newArray(int size) {
            return (new OrderItem[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4857910636045238308L;

    protected OrderItem(Parcel in) {
        in.readList(this.itemDiscounts, (com.renovite.transactionidmapper.model.order.ItemDiscount.class.getClassLoader()));
        this.itemReturn = ((ItemReturn) in.readValue((ItemReturn.class.getClassLoader())));
        in.readList(this.orderItemProperties, (String.class.getClassLoader()));
        this.orderItemRef = ((String) in.readValue((String.class.getClassLoader())));
        this.product = ((Product) in.readValue((Product.class.getClassLoader())));
        this.quantity = ((Quantity) in.readValue((Quantity.class.getClassLoader())));
        in.readList(this.taxes, (Tax.class.getClassLoader()));
        this.total = ((Total) in.readValue((Total.class.getClassLoader())));
        this.unitAmount = ((UnitAmount) in.readValue((UnitAmount.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderItem() {
    }

    /**
     * 
     * @param total
     * @param product
     * @param unitAmount
     * @param orderItemRef
     * @param quantity
     * @param itemReturn
     * @param taxes
     * @param orderItemProperties
     * @param itemDiscounts
     */
    public OrderItem(List<ItemDiscount> itemDiscounts, ItemReturn itemReturn, List<String> orderItemProperties, String orderItemRef, Product product, Quantity quantity, List<Tax> taxes, Total total, UnitAmount unitAmount) {
        super();
        this.itemDiscounts = itemDiscounts;
        this.itemReturn = itemReturn;
        this.orderItemProperties = orderItemProperties;
        this.orderItemRef = orderItemRef;
        this.product = product;
        this.quantity = quantity;
        this.taxes = taxes;
        this.total = total;
        this.unitAmount = unitAmount;
    }

    public List<ItemDiscount> getItemDiscounts() {
        return itemDiscounts;
    }

    public void setItemDiscounts(List<ItemDiscount> itemDiscounts) {
        this.itemDiscounts = itemDiscounts;
    }

    public OrderItem withItemDiscounts(List<ItemDiscount> itemDiscounts) {
        this.itemDiscounts = itemDiscounts;
        return this;
    }

    public ItemReturn getItemReturn() {
        return itemReturn;
    }

    public void setItemReturn(ItemReturn itemReturn) {
        this.itemReturn = itemReturn;
    }

    public OrderItem withItemReturn(ItemReturn itemReturn) {
        this.itemReturn = itemReturn;
        return this;
    }

    public List<String> getOrderItemProperties() {
        return orderItemProperties;
    }

    public void setOrderItemProperties(List<String> orderItemProperties) {
        this.orderItemProperties = orderItemProperties;
    }

    public OrderItem withOrderItemProperties(List<String> orderItemProperties) {
        this.orderItemProperties = orderItemProperties;
        return this;
    }

    public String getOrderItemRef() {
        return orderItemRef;
    }

    public void setOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
    }

    public OrderItem withOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderItem withProduct(Product product) {
        this.product = product;
        return this;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public OrderItem withQuantity(Quantity quantity) {
        this.quantity = quantity;
        return this;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public OrderItem withTaxes(List<Tax> taxes) {
        this.taxes = taxes;
        return this;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public OrderItem withTotal(Total total) {
        this.total = total;
        return this;
    }

    public UnitAmount getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(UnitAmount unitAmount) {
        this.unitAmount = unitAmount;
    }

    public OrderItem withUnitAmount(UnitAmount unitAmount) {
        this.unitAmount = unitAmount;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("itemDiscounts", itemDiscounts).append("itemReturn", itemReturn).append("orderItemProperties", orderItemProperties).append("orderItemRef", orderItemRef).append("product", product).append("quantity", quantity).append("taxes", taxes).append("total", total).append("unitAmount", unitAmount).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(total).append(product).append(unitAmount).append(orderItemRef).append(quantity).append(itemReturn).append(taxes).append(orderItemProperties).append(itemDiscounts).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderItem) == false) {
            return false;
        }
        OrderItem rhs = ((OrderItem) other);
        return new EqualsBuilder().append(total, rhs.total).append(product, rhs.product).append(unitAmount, rhs.unitAmount).append(orderItemRef, rhs.orderItemRef).append(quantity, rhs.quantity).append(itemReturn, rhs.itemReturn).append(taxes, rhs.taxes).append(orderItemProperties, rhs.orderItemProperties).append(itemDiscounts, rhs.itemDiscounts).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(itemDiscounts);
        dest.writeValue(itemReturn);
        dest.writeList(orderItemProperties);
        dest.writeValue(orderItemRef);
        dest.writeValue(product);
        dest.writeValue(quantity);
        dest.writeList(taxes);
        dest.writeValue(total);
        dest.writeValue(unitAmount);
    }

    public int describeContents() {
        return  0;
    }

}

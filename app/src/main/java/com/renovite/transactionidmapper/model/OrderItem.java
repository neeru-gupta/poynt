
package com.renovite.transactionidmapper.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItem implements Parcelable
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

    protected OrderItem(Parcel in) {
        in.readList(this.itemDiscounts, (ItemDiscount.class.getClassLoader()));
        this.itemReturn = ((ItemReturn) in.readValue((ItemReturn.class.getClassLoader())));
        in.readList(this.orderItemProperties, (String.class.getClassLoader()));
        this.orderItemRef = ((String) in.readValue((String.class.getClassLoader())));
        this.product = ((Product) in.readValue((Product.class.getClassLoader())));
        this.quantity = ((Quantity) in.readValue((Quantity.class.getClassLoader())));
        in.readList(this.taxes, (com.renovite.transactionidmapper.model.Tax.class.getClassLoader()));
        this.total = ((Total) in.readValue((Total.class.getClassLoader())));
        this.unitAmount = ((UnitAmount) in.readValue((UnitAmount.class.getClassLoader())));
    }

    public OrderItem() {
    }

    public List<ItemDiscount> getItemDiscounts() {
        return itemDiscounts;
    }

    public void setItemDiscounts(List<ItemDiscount> itemDiscounts) {
        this.itemDiscounts = itemDiscounts;
    }

    public ItemReturn getItemReturn() {
        return itemReturn;
    }

    public void setItemReturn(ItemReturn itemReturn) {
        this.itemReturn = itemReturn;
    }

    public List<String> getOrderItemProperties() {
        return orderItemProperties;
    }

    public void setOrderItemProperties(List<String> orderItemProperties) {
        this.orderItemProperties = orderItemProperties;
    }

    public String getOrderItemRef() {
        return orderItemRef;
    }

    public void setOrderItemRef(String orderItemRef) {
        this.orderItemRef = orderItemRef;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public UnitAmount getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(UnitAmount unitAmount) {
        this.unitAmount = unitAmount;
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

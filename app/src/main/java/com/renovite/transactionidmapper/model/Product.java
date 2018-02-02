
package com.renovite.transactionidmapper.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable
{

    @SerializedName("brands")
    @Expose
    private List<String> brands = null;
    @SerializedName("category")
    @Expose
    private List<String> category = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageUrl")
    @Expose
    private ImageUrl imageUrl;
    @SerializedName("logoUrl")
    @Expose
    private LogoUrl logoUrl;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("productIdentifier")
    @Expose
    private ProductIdentifier productIdentifier;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("url")
    @Expose
    private Url url;
    public final static Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;

    protected Product(Parcel in) {
        in.readList(this.brands, (String.class.getClassLoader()));
        in.readList(this.category, (String.class.getClassLoader()));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((ImageUrl) in.readValue((ImageUrl.class.getClassLoader())));
        this.logoUrl = ((LogoUrl) in.readValue((LogoUrl.class.getClassLoader())));
        this.manufacturer = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.productIdentifier = ((ProductIdentifier) in.readValue((ProductIdentifier.class.getClassLoader())));
        this.sku = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((Url) in.readValue((Url.class.getClassLoader())));
    }

    public Product() {
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LogoUrl getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(LogoUrl logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductIdentifier getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(ProductIdentifier productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(brands);
        dest.writeList(category);
        dest.writeValue(description);
        dest.writeValue(imageUrl);
        dest.writeValue(logoUrl);
        dest.writeValue(manufacturer);
        dest.writeValue(model);
        dest.writeValue(name);
        dest.writeValue(productIdentifier);
        dest.writeValue(sku);
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}

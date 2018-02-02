
package com.renovite.transactionidmapper.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipment implements Parcelable
{

    @SerializedName("carrier")
    @Expose
    private String carrier;
    @SerializedName("destination")
    @Expose
    private Destination destination;
    @SerializedName("expectedFrom")
    @Expose
    private String expectedFrom;
    @SerializedName("expectedUntil")
    @Expose
    private String expectedUntil;
    @SerializedName("origin")
    @Expose
    private Origin origin;
    @SerializedName("shipmentItems")
    @Expose
    private List<ShipmentItem> shipmentItems = null;
    @SerializedName("shipmentRef")
    @Expose
    private String shipmentRef;
    @SerializedName("shippingMethod")
    @Expose
    private String shippingMethod;
    @SerializedName("trackingNumber")
    @Expose
    private String trackingNumber;
    @SerializedName("trackingUrl")
    @Expose
    private TrackingUrl trackingUrl;
    public final static Creator<Shipment> CREATOR = new Creator<Shipment>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shipment createFromParcel(Parcel in) {
            return new Shipment(in);
        }

        public Shipment[] newArray(int size) {
            return (new Shipment[size]);
        }

    }
    ;

    protected Shipment(Parcel in) {
        this.carrier = ((String) in.readValue((String.class.getClassLoader())));
        this.destination = ((Destination) in.readValue((Destination.class.getClassLoader())));
        this.expectedFrom = ((String) in.readValue((String.class.getClassLoader())));
        this.expectedUntil = ((String) in.readValue((String.class.getClassLoader())));
        this.origin = ((Origin) in.readValue((Origin.class.getClassLoader())));
        in.readList(this.shipmentItems, (com.renovite.transactionidmapper.model.ShipmentItem.class.getClassLoader()));
        this.shipmentRef = ((String) in.readValue((String.class.getClassLoader())));
        this.shippingMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.trackingNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.trackingUrl = ((TrackingUrl) in.readValue((TrackingUrl.class.getClassLoader())));
    }

    public Shipment() {
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getExpectedFrom() {
        return expectedFrom;
    }

    public void setExpectedFrom(String expectedFrom) {
        this.expectedFrom = expectedFrom;
    }

    public String getExpectedUntil() {
        return expectedUntil;
    }

    public void setExpectedUntil(String expectedUntil) {
        this.expectedUntil = expectedUntil;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public List<ShipmentItem> getShipmentItems() {
        return shipmentItems;
    }

    public void setShipmentItems(List<ShipmentItem> shipmentItems) {
        this.shipmentItems = shipmentItems;
    }

    public String getShipmentRef() {
        return shipmentRef;
    }

    public void setShipmentRef(String shipmentRef) {
        this.shipmentRef = shipmentRef;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public TrackingUrl getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(TrackingUrl trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(carrier);
        dest.writeValue(destination);
        dest.writeValue(expectedFrom);
        dest.writeValue(expectedUntil);
        dest.writeValue(origin);
        dest.writeList(shipmentItems);
        dest.writeValue(shipmentRef);
        dest.writeValue(shippingMethod);
        dest.writeValue(trackingNumber);
        dest.writeValue(trackingUrl);
    }

    public int describeContents() {
        return  0;
    }

}

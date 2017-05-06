package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 5/1/17.
 */
@Entity
@Table(name="address")
public class Address {
    private int addressId;
    private byte isBusiness;
    private String businessName;
    private String addressNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private String fullAddress;

    private Set<RideRequest> rideRequests = new HashSet<RideRequest>(
            0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ride_request")
    public Set<RideRequest> getRideRequests() {
        return this.rideRequests;
    }

    public void setRideRequests(Set<RideRequest> rideRequests) {
        this.rideRequests = rideRequests;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "address_id")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name="full_address")
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) { this.fullAddress = fullAddress;}

    @Basic
    @Column(name = "is_business")
    public byte getIsBusiness() {
        return isBusiness;
    }

    public void setIsBusiness(byte isBusiness) {
        this.isBusiness = isBusiness;
    }

    @Basic
    @Column(name = "business_name")
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Basic
    @Column(name = "address_number")
    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    @Basic
    @Column(name = "street_name")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != address.addressId) return false;
        if (isBusiness != address.isBusiness) return false;
        if (addressNumber != address.addressNumber) return false;
        if (businessName != null ? !businessName.equals(address.businessName) : address.businessName != null)
            return false;
        if (streetName != null ? !streetName.equals(address.streetName) : address.streetName != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        if (zipCode != null ? !zipCode.equals(address.zipCode) : address.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId;
        result = 31 * result + (int) isBusiness;
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (addressNumber != null ? addressNumber.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}

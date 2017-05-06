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
//    private byte isBusiness;
    private String businessName;
    private String addressNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private String fullAddress;

    private Set<RideRequest> pickupRideRequests = new HashSet<RideRequest>(0);
    private Set<RideRequest> dropoffRideRequests = new HashSet<RideRequest>(0);
    private Set<Ride> rideStartingAddresses = new HashSet<Ride>(0);
    private Set<Ride> rideEndingAddresses = new HashSet<Ride>(0);
    private Set<User> usersAddresses = new HashSet<User>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy="homeAddress")
    public Set<User> getUsersAddresses() {
        return this.usersAddresses;
    }

    public void setUsersAddresses(Set<User> usersAddresses) {
        this.usersAddresses = usersAddresses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="startAddress")
    public Set<Ride> getRideStartingAddresses() {
        return this.rideStartingAddresses;
    }

    public void setRideStartingAddresses(Set<Ride> rideStartingAddresses) {
        this.rideStartingAddresses = rideStartingAddresses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="endAddress")
    public Set<Ride> getRideEndingAddresses() {
        return this.rideEndingAddresses;
    }

    public void setRideEndingAddresses(Set<Ride> rideEndingAddresses) {
        this.rideEndingAddresses = rideEndingAddresses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="pickupAddress")
    public Set<RideRequest> getPickupRideRequests() {
        return this.pickupRideRequests;
    }

    public void setPickupRideRequests(Set<RideRequest> rideRequests) {
        this.pickupRideRequests = rideRequests;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="dropoffAddress")
    public Set<RideRequest> getDropoffRideRequests() {
        return this.dropoffRideRequests;
    }

    public void setDropoffRideRequests(Set<RideRequest> rideRequests) {
        this.dropoffRideRequests = rideRequests;
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
    @Column(name = "house_number")
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
//        if (isBusiness != address.isBusiness) return false;
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
//        result = 31 * result + (int) isBusiness;
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (addressNumber != null ? addressNumber.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}

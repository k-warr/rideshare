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

    /**
     * Instantiates a new Address.
     */
    public Address() {

    }

    /**
     * Instantiates a new Address.
     *
     * @param addressNumber the address number
     * @param streetName    the street name
     * @param city          the city
     * @param state         the state
     * @param zipCode       the zip code
     */
    public Address(String addressNumber, String streetName, String city, String state, String zipCode) {
        this();
        setAddressNumber(addressNumber);
        setStreetName(streetName);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setFullAddress(getAddressNumber()
                + " " + getStreetName()
                + " " + getCity()
                + ", " + getState()
                + " " + getZipCode());
    }

    /**
     * Gets users addresses.
     *
     * @return the users addresses
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy="homeAddress")
    public Set<User> getUsersAddresses() {
        return this.usersAddresses;
    }

    /**
     * Sets users addresses.
     *
     * @param usersAddresses the users addresses
     */
    public void setUsersAddresses(Set<User> usersAddresses) {
        this.usersAddresses = usersAddresses;
    }

    /**
     * Gets ride starting addresses.
     *
     * @return the ride starting addresses
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy="startAddress")
    public Set<Ride> getRideStartingAddresses() {
        return this.rideStartingAddresses;
    }

    /**
     * Sets ride starting addresses.
     *
     * @param rideStartingAddresses the ride starting addresses
     */
    public void setRideStartingAddresses(Set<Ride> rideStartingAddresses) {
        this.rideStartingAddresses = rideStartingAddresses;
    }

    /**
     * Gets ride ending addresses.
     *
     * @return the ride ending addresses
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy="endAddress")
    public Set<Ride> getRideEndingAddresses() {
        return this.rideEndingAddresses;
    }

    /**
     * Sets ride ending addresses.
     *
     * @param rideEndingAddresses the ride ending addresses
     */
    public void setRideEndingAddresses(Set<Ride> rideEndingAddresses) {
        this.rideEndingAddresses = rideEndingAddresses;
    }

    /**
     * Gets pickup ride requests.
     *
     * @return the pickup ride requests
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy="pickupAddress")
    public Set<RideRequest> getPickupRideRequests() {
        return this.pickupRideRequests;
    }

    /**
     * Sets pickup ride requests.
     *
     * @param rideRequests the ride requests
     */
    public void setPickupRideRequests(Set<RideRequest> rideRequests) {
        this.pickupRideRequests = rideRequests;
    }

    /**
     * Gets dropoff ride requests.
     *
     * @return the dropoff ride requests
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy="dropoffAddress")
    public Set<RideRequest> getDropoffRideRequests() {
        return this.dropoffRideRequests;
    }

    /**
     * Sets dropoff ride requests.
     *
     * @param rideRequests the ride requests
     */
    public void setDropoffRideRequests(Set<RideRequest> rideRequests) {
        this.dropoffRideRequests = rideRequests;
    }

    /**
     * Gets address id.
     *
     * @return the address id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "address_id")
    public int getAddressId() {
        return addressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets full address.
     *
     * @return the full address
     */
    @Basic
    @Column(name="full_address")
    public String getFullAddress() {
        return fullAddress;
    }

    /**
     * Sets full address.
     *
     * @param fullAddress the full address
     */
    public void setFullAddress(String fullAddress) { this.fullAddress = fullAddress;}

    /**
     * Gets address number.
     *
     * @return the address number
     */
    @Basic
    @Column(name = "house_number")
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     * Sets address number.
     *
     * @param addressNumber the address number
     */
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    /**
     * Gets street name.
     *
     * @return the street name
     */
    @Basic
    @Column(name = "street_name")
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    @Basic
    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressId != address.addressId) return false;
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
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (addressNumber != null ? addressNumber.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}

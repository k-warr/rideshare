package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 4/30/17.
 */
@Entity
@Table(name="user")
public class User {
    private int userId;
    private String password;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private Address homeAddress;
    private Vehicle vehicle;
    private int maxRidersInclDriver;
    private String vin;
    private String insuranceProvider;
    private String driversLicense;
    private String licensePlate;
    private int isDriver;
    //    private VehicleOwner vehicleOwner;
//    private Integer homeAddressId;
    private Set<RideRequest> rideRequests = new HashSet<RideRequest>(0);

    @Basic
    @Column(name = "max_riders_incl_driver")
    public int getMaxRidersInclDriver() {
        return maxRidersInclDriver;
    }

    public void setMaxRidersInclDriver(int maxRidersInclDriver) {
        this.maxRidersInclDriver = maxRidersInclDriver;
    }

    @Basic
    @Column(name = "isDriver")
    public int getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(int isDriver) {
        this.isDriver = isDriver;
    }

    @Basic
    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "insurance_provider")
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    @Basic
    @Column(name = "drivers_license")
    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    @Basic
    @Column(name = "license_plate")
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy="user")
    public Set<RideRequest> getRideStartingAddresses() {
        return this.rideRequests;
    }

    public void setRideStartingAddresses(Set<RideRequest> rideRequests) {
        this.rideRequests = rideRequests;
    }

    @Id
//    @GeneratedValue(generator = "increment")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
//    public VehicleOwner getVehicleOwner() {
//        return vehicleOwner;
//    }
//
//    public void setVehicleOwner(VehicleOwner vehicleOwner) {
//        this.vehicleOwner = vehicleOwner;
//    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_vehicle_id")
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "home_address_id")
    public Address getHomeAddress() {
        return this.homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {this.homeAddress = homeAddress;}

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

//    @Basic
//    @Column(name = "home_address_id")
//    public Integer getHomeAddressId() {
//        return homeAddressId;
//    }
//
//    public void setHomeAddressId(Integer homeAddressId) {
//        this.homeAddressId = homeAddressId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (phone != user.phone) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
////        if (homeAddressId != null ? !homeAddressId.equals(user.homeAddressId) : user.homeAddressId != null)
//            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + phone;
//        result = 31 * result + (homeAddressId != null ? homeAddressId.hashCode() : 0);
        return result;
    }
}

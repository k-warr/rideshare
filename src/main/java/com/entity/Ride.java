package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kien Warren on 4/30/17.
 */
@Entity
@Table(name="ride")
public class Ride {
    private int rideId;
    private int userUserId;
    private Address startAddress;
    private Address endAddress;
    private int departTime;
    private String recurrenceDay;
    private int numOfRecurrences;
    private byte rideIsFull;
    private Date requestDateTime;
    private int numRidersInclDriver;
    private Set<RideRequest> rideRequests = new HashSet<>();

    @Basic
    @Column(name = "num_riders_incl_driver")
    public int getNumRidersInclDriver() {
        return numRidersInclDriver;
    }

    public void setNumRidersInclDriver(int numRidersInclDriver) {
        this.numRidersInclDriver = numRidersInclDriver;
    }


    @OneToMany(fetch = FetchType.EAGER, mappedBy="ride")
    public Set<RideRequest> getRideRequests() {
        return this.rideRequests;
    }

    public void setRideRequests(Set<RideRequest> rideRequests) {
        this.rideRequests = rideRequests;
    }

    @Basic
    @Column(name = "ride_datetime", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "start_address_id", nullable = false)
    public Address getStartAddress() {
        return this.startAddress;
    }

    public void setStartAddress(Address address) {this.startAddress = address;}

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_address_id", nullable = false)
    public Address getEndAddress() {
        return this.endAddress;
    }

    public void setEndAddress(Address address) {this.endAddress = address;}

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ride_id")
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Basic
    @Column(name = "user_user_id")
    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Basic
    @Column(name = "depart_time")
    public int getDepartTime() {
        return departTime;
    }

    public void setDepartTime(int departTime) {
        this.departTime = departTime;
    }

    @Basic
    @Column(name = "recurrence_day")
    public String getRecurrenceDay() {
        return recurrenceDay;
    }

    public void setRecurrenceDay(String recurrenceDay) {
        this.recurrenceDay = recurrenceDay;
    }

    @Basic
    @Column(name = "num_of_recurrences")
    public Integer getNumOfRecurrences() {
        return numOfRecurrences;
    }

    public void setNumOfRecurrences(Integer numOfRecurrences) {
        this.numOfRecurrences = numOfRecurrences;
    }

    @Basic
    @Column(name = "ride_is_full")
    public byte getRideIsFull() {
        return rideIsFull;
    }

    public void setRideIsFull(byte rideIsFull) {
        this.rideIsFull = rideIsFull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (rideId != ride.rideId) return false;
//        if (userUserId != ride.userUserId) return false;
//        if (startAddressId != ride.startAddressId) return false;
//        if (endAddressId != ride.endAddressId) return false;
        if (rideIsFull != ride.rideIsFull) return false;
//        if (vehicleOwnerId != ride.vehicleOwnerId) return false;
//        if (departTime != null ? !departTime.equals(ride.departTime) : ride.departTime != null) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(ride.recurrenceDay) : ride.recurrenceDay != null)
            return false;
//        if (numOfRecurrences != null ? !numOfRecurrences.equals(ride.numOfRecurrences) : ride.numOfRecurrences != null)
//            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
//        result = 31 * result + userUserId;
//        result = 31 * result + startAddressId;
//        result = 31 * result + endAddressId;
//        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
//        result = 31 * result + (numOfRecurrences != null ? numOfRecurrences.hashCode() : 0);
        result = 31 * result + (int) rideIsFull;
//        result = 31 * result + vehicleOwnerId;
        return result;
    }
}

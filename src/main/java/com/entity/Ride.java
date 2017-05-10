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

    /**
     * Gets num riders incl driver.
     *
     * @return the num riders incl driver
     */
    @Basic
    @Column(name = "num_riders_incl_driver")
    public int getNumRidersInclDriver() {
        return numRidersInclDriver;
    }

    /**
     * Sets num riders incl driver.
     *
     * @param numRidersInclDriver the num riders incl driver
     */
    public void setNumRidersInclDriver(int numRidersInclDriver) {
        this.numRidersInclDriver = numRidersInclDriver;
    }


    /**
     * Gets ride requests.
     *
     * @return the ride requests
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy="ride")
    public Set<RideRequest> getRideRequests() {
        return this.rideRequests;
    }

    /**
     * Sets ride requests.
     *
     * @param rideRequests the ride requests
     */
    public void setRideRequests(Set<RideRequest> rideRequests) {
        this.rideRequests = rideRequests;
    }

    /**
     * Gets request date time.
     *
     * @return the request date time
     */
    @Basic
    @Column(name = "ride_datetime", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRequestDateTime() {
        return requestDateTime;
    }

    /**
     * Sets request date time.
     *
     * @param requestDateTime the request date time
     */
    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    /**
     * Gets start address.
     *
     * @return the start address
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "start_address_id", nullable = false)
    public Address getStartAddress() {
        return this.startAddress;
    }

    /**
     * Sets start address.
     *
     * @param address the address
     */
    public void setStartAddress(Address address) {this.startAddress = address;}

    /**
     * Gets end address.
     *
     * @return the end address
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_address_id", nullable = false)
    public Address getEndAddress() {
        return this.endAddress;
    }

    /**
     * Sets end address.
     *
     * @param address the address
     */
    public void setEndAddress(Address address) {this.endAddress = address;}

    /**
     * Gets ride id.
     *
     * @return the ride id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ride_id")
    public int getRideId() {
        return rideId;
    }

    /**
     * Sets ride id.
     *
     * @param rideId the ride id
     */
    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    /**
     * Gets user user id.
     *
     * @return the user user id
     */
    @Basic
    @Column(name = "user_user_id")
    public int getUserUserId() {
        return userUserId;
    }

    /**
     * Sets user user id.
     *
     * @param userUserId the user user id
     */
    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    /**
     * Gets depart time.
     *
     * @return the depart time
     */
    @Basic
    @Column(name = "depart_time")
    public int getDepartTime() {
        return departTime;
    }

    /**
     * Sets depart time.
     *
     * @param departTime the depart time
     */
    public void setDepartTime(int departTime) {
        this.departTime = departTime;
    }

    /**
     * Gets recurrence day.
     *
     * @return the recurrence day
     */
    @Basic
    @Column(name = "recurrence_day")
    public String getRecurrenceDay() {
        return recurrenceDay;
    }

    /**
     * Sets recurrence day.
     *
     * @param recurrenceDay the recurrence day
     */
    public void setRecurrenceDay(String recurrenceDay) {
        this.recurrenceDay = recurrenceDay;
    }

    /**
     * Gets num of recurrences.
     *
     * @return the num of recurrences
     */
    @Basic
    @Column(name = "num_of_recurrences")
    public Integer getNumOfRecurrences() {
        return numOfRecurrences;
    }

    /**
     * Sets num of recurrences.
     *
     * @param numOfRecurrences the num of recurrences
     */
    public void setNumOfRecurrences(Integer numOfRecurrences) {
        this.numOfRecurrences = numOfRecurrences;
    }

    /**
     * Gets ride is full.
     *
     * @return the ride is full
     */
    @Basic
    @Column(name = "ride_is_full")
    public byte getRideIsFull() {
        return rideIsFull;
    }

    /**
     * Sets ride is full.
     *
     * @param rideIsFull the ride is full
     */
    public void setRideIsFull(byte rideIsFull) {
        this.rideIsFull = rideIsFull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (rideId != ride.rideId) return false;
        if (rideIsFull != ride.rideIsFull) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(ride.recurrenceDay) : ride.recurrenceDay != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + (int) rideIsFull;
        return result;
    }
}

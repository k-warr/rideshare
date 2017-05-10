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
@Table(name = "ride_request")
public class RideRequest {
    private int requestId;
    private User user;
    private String recurrenceDay;
    private int dropoffTime;
    private String requestStatus;
    private Address pickupAddress;
    private Address dropoffAddress;
    private Date requestTime;
    private Ride ride;

    /**
     * Gets ride.
     *
     * @return the ride
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ride_ride_id")
    public Ride getRide() {
        return this.ride;
    }

    /**
     * Sets ride.
     *
     * @param ride the ride
     */
    public void setRide(Ride ride) {this.ride = ride;}

    /**
     * Gets request time.
     *
     * @return the request time
     */
    @Basic
    @Column(name = "request_time", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * Sets request time.
     *
     * @param requestTime the request time
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {this.user = user;}

    /**
     * Gets request id.
     *
     * @return the request id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "request_id")
    public int getRequestId() {
        return requestId;
    }

    /**
     * Sets request id.
     *
     * @param requestId the request id
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets pickup address.
     *
     * @return the pickup address
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pickup_address_id", nullable = false)
    public Address getPickupAddress() {
        return this.pickupAddress;
    }

    /**
     * Sets pickup address.
     *
     * @param address the address
     */
    public void setPickupAddress(Address address) {this.pickupAddress = address;}

    /**
     * Gets dropoff address.
     *
     * @return the dropoff address
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dropoff_address_id", nullable = false)
    public Address getDropoffAddress() {
        return this.dropoffAddress;
    }

    /**
     * Sets dropoff address.
     *
     * @param address the address
     */
    public void setDropoffAddress(Address address) {this.dropoffAddress = address;}

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
     * Gets dropoff time.
     *
     * @return the dropoff time
     */
    @Basic
    @Column(name = "dropoff_time")
    public int getDropoffTime() {
        return dropoffTime;
    }

    /**
     * Sets dropoff time.
     *
     * @param dropoffTime the dropoff time
     */
    public void setDropoffTime(int dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    /**
     * Gets request status.
     *
     * @return the request status
     */
    @Basic
    @Column(name = "request_status")
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets request status.
     *
     * @param requestStatus the request status
     */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RideRequest that = (RideRequest) o;

        if (requestId != that.requestId) return false;
        if (dropoffTime != that.dropoffTime) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(that.recurrenceDay) : that.recurrenceDay != null)
            return false;
        if (requestStatus != null ? !requestStatus.equals(that.requestStatus) : that.requestStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + dropoffTime;
        result = 31 * result + (requestStatus != null ? requestStatus.hashCode() : 0);
        return result;
    }
}

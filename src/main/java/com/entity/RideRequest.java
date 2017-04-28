package com.entity;

import javax.persistence.*;

/**
 * Created by student on 4/27/17.
 */
@Entity
@Table(name = "ride_request")
public class RideRequest {
    private int requestId;
    private int userId;
    private int pickupAddressId;
    private int dropoffAddressId;
    private String recurrenceDay;
    private int dropoffTime;
    private Integer rideId;
    private Byte activeRequest;

    @Id
    @Column(name = "request_id")
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "pickup_address_id")
    public int getPickupAddressId() {
        return pickupAddressId;
    }

    public void setPickupAddressId(int pickupAddressId) {
        this.pickupAddressId = pickupAddressId;
    }

    @Basic
    @Column(name = "dropoff_address_id")
    public int getDropoffAddressId() {
        return dropoffAddressId;
    }

    public void setDropoffAddressId(int dropoffAddressId) {
        this.dropoffAddressId = dropoffAddressId;
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
    @Column(name = "dropoff_time")
    public int getDropoffTime() {
        return dropoffTime;
    }

    public void setDropoffTime(int dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    @Basic
    @Column(name = "ride_id")
    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    @Basic
    @Column(name = "active_request")
    public Byte getActiveRequest() {
        return activeRequest;
    }

    public void setActiveRequest(Byte activeRequest) {
        this.activeRequest = activeRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RideRequest that = (RideRequest) o;

        if (requestId != that.requestId) return false;
        if (userId != that.userId) return false;
        if (pickupAddressId != that.pickupAddressId) return false;
        if (dropoffAddressId != that.dropoffAddressId) return false;
        if (dropoffTime != that.dropoffTime) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(that.recurrenceDay) : that.recurrenceDay != null)
            return false;
        if (rideId != null ? !rideId.equals(that.rideId) : that.rideId != null) return false;
        if (activeRequest != null ? !activeRequest.equals(that.activeRequest) : that.activeRequest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + userId;
        result = 31 * result + pickupAddressId;
        result = 31 * result + dropoffAddressId;
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + dropoffTime;
        result = 31 * result + (rideId != null ? rideId.hashCode() : 0);
        result = 31 * result + (activeRequest != null ? activeRequest.hashCode() : 0);
        return result;
    }
}

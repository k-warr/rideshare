package com.entity;

import javax.persistence.*;

/**
 * Created by student on 4/27/17.
 */
@Entity
@IdClass(RidePK.class)
@Table(name="ride")
public class Ride {
    private int userUserId;
    private int rideId;
    private int startAddressId;
    private int endAddressId;
    private String departTime;
    private String recurrenceDay;
    private Integer numOfRecurrences;
    private int vehicleOwnerId;
    private byte rideIsFull;

    @Basic
    @Column(name = "user_user_id")
    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Id
    @Column(name = "ride_id")
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Basic
    @Column(name = "start_address_id")
    public int getStartAddressId() {
        return startAddressId;
    }

    public void setStartAddressId(int startAddressId) {
        this.startAddressId = startAddressId;
    }

    @Basic
    @Column(name = "end_address_id")
    public int getEndAddressId() {
        return endAddressId;
    }

    public void setEndAddressId(int endAddressId) {
        this.endAddressId = endAddressId;
    }

    @Id
    @Column(name = "depart_time")
    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
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
    @Column(name = "vehicle_owner_id")
    public int getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(int vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
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

        if (userUserId != ride.userUserId) return false;
        if (rideId != ride.rideId) return false;
        if (startAddressId != ride.startAddressId) return false;
        if (endAddressId != ride.endAddressId) return false;
        if (vehicleOwnerId != ride.vehicleOwnerId) return false;
        if (rideIsFull != ride.rideIsFull) return false;
        if (departTime != null ? !departTime.equals(ride.departTime) : ride.departTime != null) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(ride.recurrenceDay) : ride.recurrenceDay != null)
            return false;
        if (numOfRecurrences != null ? !numOfRecurrences.equals(ride.numOfRecurrences) : ride.numOfRecurrences != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userUserId;
        result = 31 * result + rideId;
        result = 31 * result + startAddressId;
        result = 31 * result + endAddressId;
        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + (numOfRecurrences != null ? numOfRecurrences.hashCode() : 0);
        result = 31 * result + vehicleOwnerId;
        result = 31 * result + (int) rideIsFull;
        return result;
    }
}

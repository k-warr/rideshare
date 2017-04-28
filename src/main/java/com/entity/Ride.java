package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 4/27/17.
 */
@Entity
@Table(name="ride")
public class Ride {
    private int rideId;
    private String departTime;
    private String recurrenceDay;
    private Integer numOfRecurrences;
    private int vehicleId;
    private byte rideIsFull;

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
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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
        if (vehicleId != ride.vehicleId) return false;
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
        int result = rideId;
        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + (numOfRecurrences != null ? numOfRecurrences.hashCode() : 0);
        result = 31 * result + vehicleId;
        result = 31 * result + (int) rideIsFull;
        return result;
    }
}

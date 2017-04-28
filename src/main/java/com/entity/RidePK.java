package com.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 4/27/17.
 */
public class RidePK implements Serializable {
    private int rideId;
    private String departTime;

    @Column(name = "ride_id")
    @Id
    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    @Column(name = "depart_time")
    @Id
    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RidePK ridePK = (RidePK) o;

        if (rideId != ridePK.rideId) return false;
        if (departTime != null ? !departTime.equals(ridePK.departTime) : ridePK.departTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rideId;
        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        return result;
    }
}

package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 4/27/17.
 */
@Entity
@Table(name = "ride_request")
public class RideRequest {
    private int requestId;
    private String recurrenceDay;
    private int dropoffTime;
    private Byte activeRequest;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "request_id")
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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
        if (dropoffTime != that.dropoffTime) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(that.recurrenceDay) : that.recurrenceDay != null)
            return false;
        if (activeRequest != null ? !activeRequest.equals(that.activeRequest) : that.activeRequest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + dropoffTime;
        result = 31 * result + (activeRequest != null ? activeRequest.hashCode() : 0);
        return result;
    }
}

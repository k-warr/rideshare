package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by student on 4/30/17.
 */
@Entity
@Table(name = "ride_request")
public class RideRequest {
    private int requestId;
    private int userId;
    private User user;
    private String recurrenceDay;
    private int dropoffTime;
    private Integer rideId;
    private String requestStatus;
    private Address pickupAddress;
    private Address dropoffAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {this.user = user;}

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pickup_address_id", nullable = false)
    public Address getPickupAddress() {
        return this.pickupAddress;
    }

    public void setPickupAddress(Address address) {this.pickupAddress = address;}

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dropoff_address_id", nullable = false)
    public Address getDropoffAddress() {
        return this.dropoffAddress;
    }

    public void setDropoffAddress(Address address) {this.dropoffAddress = address;}

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "request_status")
    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

//    @Transient
//    public String getActiveRequestAsString() {
//        if (requestStatus == (byte) 1 && rideId == null) {
//            return "Active";
//        }
//        else if (requestStatus == (byte) 0 && rideId != null) {
//            return "";
//        } else {
//            return "Unknown";
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RideRequest that = (RideRequest) o;

        if (requestId != that.requestId) return false;
        if (userId != that.userId) return false;
        if (dropoffTime != that.dropoffTime) return false;
        if (recurrenceDay != null ? !recurrenceDay.equals(that.recurrenceDay) : that.recurrenceDay != null)
            return false;
        if (rideId != null ? !rideId.equals(that.rideId) : that.rideId != null) return false;
        if (requestStatus != null ? !requestStatus.equals(that.requestStatus) : that.requestStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestId;
        result = 31 * result + userId;
        result = 31 * result + (recurrenceDay != null ? recurrenceDay.hashCode() : 0);
        result = 31 * result + dropoffTime;
        result = 31 * result + (rideId != null ? rideId.hashCode() : 0);
        result = 31 * result + (requestStatus != null ? requestStatus.hashCode() : 0);
        return result;
    }
}

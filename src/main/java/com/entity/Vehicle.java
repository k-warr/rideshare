package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kien Warren on 4/30/17.
 */
@Entity
@Table(name="vehicle")
public class Vehicle {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private Set<User> users = new HashSet<>();

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param make  the make
     * @param model the model
     * @param year  the year
     */
    public Vehicle(String make, String model, int year) {
        this();
        setMake(make);
        setModel(model);
        setYear(year);
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy="vehicle")
    public Set<User> getUsers() {
        return this.users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Gets vehicle id.
     *
     * @return the vehicle id
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets vehicle id.
     *
     * @param vehicleId the vehicle id
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Gets make.
     *
     * @return the make
     */
    @Basic
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    /**
     * Sets make.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (vehicleId != vehicle.vehicleId) return false;
        if (year != vehicle.year) return false;
        if (make != null ? !make.equals(vehicle.make) : vehicle.make != null) return false;
        if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vehicleId;
        result = 31 * result + (make != null ? make.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
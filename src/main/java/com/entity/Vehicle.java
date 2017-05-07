package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 4/30/17.
 */
@Entity
@Table(name="vehicle")
public class Vehicle {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private Set<VehicleOwner> vehicleOwners = new HashSet<VehicleOwner>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy="vehicle")
    public Set<VehicleOwner> getVehicleOwners() {
        return this.vehicleOwners;
    }

    public void setVehicleOwners(Set<VehicleOwner> vehicleOwners) {
        this.vehicleOwners = vehicleOwners;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

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

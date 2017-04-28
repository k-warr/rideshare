package com.persistence;

import com.entity.Vehicle;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Created by student on 2/28/17.
 */
public class VehicleDaoTest {

    private VehicleDao dao;

    @Before
    public void setup() {dao = new VehicleDao();}

    @Test
    public void addVehicleTest() throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("Toyota");
        vehicle.setModel("Prius");
        vehicle.setYear(2010);

        int vehicleId = dao.addVehicle(vehicle);


        assertEquals("addVehicleTest failed", 0, vehicleId);

    }

}
package com.persistence;

import com.entity.Ride;
import com.entity.User;
import com.entity.VehicleOwner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 4/12/17.
 */
public class RideDaoTest {
    RideDao dao;
    Ride testRide;
    User user;
    VehicleOwner vehicleOwner;

    @Before
    public void setup() {
        dao = new RideDao();
        testRide = new Ride();
        user = new User();
        user.setUserId(1);
        vehicleOwner = new VehicleOwner();

        testRide.setDepartTime("0830");
        testRide.setPickupAddressesIds("12");
        testRide.setRecurrence("MWF");
        testRide.setRideIsFull((byte) 1);
        testRide.setVehicleId(1);
        testRide.setRiderUserIds("1,2,3");
//        testRide.setVehicleOwnerUser();
        testRide.setVehicleOwnerVehicle(new VehicleOwner());

    }

    @Test
    public void addRide() throws Exception {
        int id = dao.addRide(testRide);

//        assertEquals(1, id);
    }

    @Test
    public void getAllRides() throws Exception {

    }

    @Test
    public void getRide() throws Exception {

    }

}
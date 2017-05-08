package com.persistence;

import com.entity.Ride;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 4/30/17.
 */
public class RideDaoTest {
    RideDao dao;
    Ride testRide;
    int newRide;

    @Before
    public void setUp() throws Exception {
        dao = new RideDao();
        testRide = new Ride();
        testRide.setUserUserId(2);
//        testRide.setVehicleOwnerId(1);
//        testRide.setStartAddressId(1);
//        testRide.setEndAddressId(2);
        testRide.setRecurrenceDay("Z");
        testRide.setNumOfRecurrences(4);
        newRide = 0;
    }

    @After
    public void tearDown() throws Exception {
        if (newRide != 0) {
            dao.deleteRide(newRide);
        }
    }

    @Test
    public void getAllRides() throws Exception {
        List<Ride> rides = dao.getAllRides();
        assertTrue(rides.size() > 0);
    }

    @Test
    public void getRide() throws Exception {
        newRide = dao.addRide(testRide);
        assertEquals("Ride ID not returned correctly", 1, dao.getRide(1).getRideId());
    }

    @Test
    public void addRide() throws Exception {
        newRide = dao.addRide(testRide);
        assertEquals("Ride ID not returned correctly", testRide.getRideId(), newRide);
    }

    @Test
    public void deleteRide() throws Exception {
        newRide = dao.addRide(testRide);
        dao.deleteRide(newRide);
        assertNull("deleteRide failed", dao.getRide(newRide));
    }

    @Test
    public void updateRide() throws Exception {

    }

}
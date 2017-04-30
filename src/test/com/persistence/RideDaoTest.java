package com.persistence;

import com.entity.Ride;
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

    @Before
    public void setUp() throws Exception {
        dao = new RideDao();
        testRide = new Ride();
        testRide.setUserUserId(2);
        testRide.setVehicleOwnerId(1);
        testRide.setStartAddressId(1);
        testRide.setEndAddressId(2);
        testRide.setRecurrenceDay("M");
        testRide.setNumOfRecurrences(4);
    }

//    @After
//    public void tearDown() throws Exception {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        session.beginTransaction();
//        SQLQuery query = session.createSQLQuery("DELETE FROM ride WHERE recurrence_day = \'M\'");
//        query.executeUpdate();
//        session.getTransaction().commit();
//    }

    @Test
    public void getAllRides() throws Exception {
        List<Ride> rides = dao.getAllRides();
        assertTrue(rides.size() > 0);
    }

    @Test
    public void getRide() throws Exception {
        assertEquals("Ride ID not returned correctly", 1, dao.getRide(1).getRideId());
    }

    @Test
    public void addRide() throws Exception {

    }

    @Test
    public void deleteRide() throws Exception {

    }

    @Test
    public void updateRide() throws Exception {

    }

}
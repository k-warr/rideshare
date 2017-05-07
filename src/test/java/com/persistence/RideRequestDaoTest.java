package com.persistence;

import com.entity.Address;
import com.entity.RideRequest;
import com.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kien Warren on 5/3/17.
 */
public class RideRequestDaoTest {
    RideRequestDao rideRequestDao;
    RideRequest testRideRequest;
    AddressDao addressDao;
    Address originAddress;
    Address destinationAddress;
    UserDao userDao;
    User user;

    @Before
    public void setUp() throws Exception {

        rideRequestDao = new RideRequestDao();
        addressDao = new AddressDao();
        testRideRequest = new RideRequest();
        originAddress = new Address();
        destinationAddress = new Address();
        userDao = new UserDao();

        originAddress.setAddressNumber("1");
        originAddress.setStreetName("Test");
        originAddress.setCity("Testopia");
        originAddress.setState("TS");
        originAddress.setZipCode("1");
        int originAddressId = addressDao.addAddressIfDoesntExist(originAddress);

        destinationAddress.setAddressNumber("2");
        destinationAddress.setStreetName("Test");
        destinationAddress.setCity("Testopia");
        destinationAddress.setState("TS");
        destinationAddress.setZipCode("1");
        int destinationAddressId = addressDao.addAddressIfDoesntExist(destinationAddress);

//        testRideRequest.setDropoffAddressId(destinationAddressId);
        testRideRequest.setRequestStatus("Active");
        testRideRequest.setUser(userDao.getUser(1));
//        testRideRequest.setPickupAddressId(originAddressId);
        testRideRequest.setRecurrenceDay("Z");
        testRideRequest.setPickupAddress(originAddress);
        testRideRequest.setDropoffAddress(destinationAddress);
    }

//    @After
//    public void tearDown() throws Exception {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        session.beginTransaction();
//        SQLQuery query = session.createSQLQuery("DELETE FROM address WHERE state = \'TS\'");
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//
//        Session session2 = SessionFactoryProvider.getSessionFactory().openSession();
//        session2.beginTransaction();
//        SQLQuery query2 = session2.createSQLQuery("DELETE FROM ride_request WHERE recurrence_day = \'Z\'");
//        query2.executeUpdate();
//        session2.getTransaction().commit();
//        session2.close();
//    }
    @Test
    public void getAllRideRequests() throws Exception {
        List<RideRequest> rideRequests = rideRequestDao.getAllRideRequests();
        assertNotEquals("getAllRideRequests test failed", 0, rideRequests.size());
    }

    @Test
    public void addRideRequest() throws Exception {
        int id = -1;
        id = rideRequestDao.addRideRequest(testRideRequest);
        if (id != 0 && id != -1) {
            assertEquals("addRideRequest failed", testRideRequest.getRequestId(), id);
        }
    }

}
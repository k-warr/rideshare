package com.persistence;

import com.entity.Address;
import com.entity.RideRequest;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 5/2/17.
 */
public class AddressDaoTest {
    AddressDao dao;
    Address testAddress;
    RideRequestDao rideRequestDao;
    RideRequest rideRequest;

    @Before
    public void setUp() throws Exception {
        dao = new AddressDao();
        testAddress = new Address();
        testAddress.setAddressNumber("1");
        testAddress.setStreetName("Test");
        testAddress.setCity("Testopia");
        testAddress.setState("TS");
        testAddress.setZipCode("1");
        rideRequest.setRecurrenceDay("M");
//        rideRequest.setPickupAddressId(1);
//        rideRequest.setDropoffAddressId(1);
        rideRequest.setRequestStatus("Active");
        rideRequest.setDropoffTime(830);
    }

    @After
    public void tearDown() throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("DELETE FROM address WHERE state = \'TS\'");
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    public void testRelationship() throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(testAddress);
        rideRequest.setPickupAddress(testAddress);
//        testAddress.getRideRequests().add(rideRequest);
        session.save(rideRequest);
        session.getTransaction().commit();
    }

    @Test
    public void getAllAddresss() throws Exception {

    }

    @Test
    public void addressExists() throws Exception {
        dao.addAddress(testAddress);
        int returnValue = dao.existsAddress(testAddress);
        assertEquals("existsAddress failed", testAddress.getAddressId(), returnValue);
    }

}
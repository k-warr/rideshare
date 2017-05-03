package com.persistence;

import com.entity.Address;
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

    @Before
    public void setUp() throws Exception {
        dao = new AddressDao();
        testAddress = new Address();
        testAddress.setAddressNumber("1");
        testAddress.setStreetName("Test");
        testAddress.setCity("Testopia");
        testAddress.setState("TS");
        testAddress.setZipCode("1");
        testAddress.setIsBusiness((byte)0);
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
    public void getAllAddresss() throws Exception {

    }

    @Test
    public void addressExists() throws Exception {
        dao.addAddress(testAddress);
        int returnValue = dao.existsAddress(testAddress);
        assertEquals("existsAddress failed", testAddress.getAddressId(), returnValue);
    }

}
package com.persistence;

import com.entity.Address;
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
        testAddress.setAddressNumber(1);
        testAddress.setStreetName("Test");
        testAddress.setCity("Testopia");
        testAddress.setState("");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAllAddresss() throws Exception {

    }

    @Test
    public void addressExists() throws Exception {

    }

}
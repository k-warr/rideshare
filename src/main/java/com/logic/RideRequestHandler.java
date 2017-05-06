package com.logic;

import com.entity.Address;
import com.entity.RideRequest;
import com.persistence.AddressDao;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Kien Warren on 5/2/17.
 */
public class RideRequestHandler {
    private final Logger log = Logger.getLogger(this.getClass());
    private final static PropertyManager propertyManager = new PropertyManager();

    public RideRequest newRequest(Address originAddress
            , Address destinationAddress, int dropoffTime, String recurrenceDay) {
        AddressDao dao = new AddressDao();
        RideRequest rideRequest = new RideRequest();
        String urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
                + "&key="
                + propertyManager.getProperty("google_api_key"); // API Key from developers.google.com DO NOT CHANGE
        int originId = dao.addAddressIfDoesntExist(originAddress);
//        rideRequest.setPickupAddressId(originId);
        int destinationId = dao.addAddressIfDoesntExist(destinationAddress);
//        rideRequest.setDropoffAddressId(destinationId);

        return new RideRequest();
    }

}

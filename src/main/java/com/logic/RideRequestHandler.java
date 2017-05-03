package com.logic;

import com.entity.Address;
import com.entity.RideRequest;
import com.persistence.AddressDao;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Kien Warren on 5/2/17.
 */
public class RideRequestHandler {
    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;

    public RideRequestHandler() {
        properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream("rideshare.properties"));
        } catch (IOException ioException) {
            log.error("IOException in RideRequestHandler");
        } catch (Exception exception) {
            log.error("Exception in RideRequestHandler");
        }
    }

    public RideRequest newRequest(Address originAddress, Address destinationAddress) {
        String urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
                + "&key="
                + properties.getProperty("google_api_key"); // API Key from developers.google.com DO NOT CHANGE

        return new RideRequest();
    }

}

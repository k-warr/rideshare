package com.logic;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kien Warren on 5/2/17.
 */
public class PropertyManager extends Properties {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Instantiates a new Property manager that enables access to rideshare.properties.
     */
    public PropertyManager() {
        try {
            InputStream rideShareProperties =this.getClass().getResourceAsStream("/rideshare.properties");
            this.load(rideShareProperties);
        } catch (IOException ioException) {
            log.error("IOException in PropertyManager");
        } catch (Exception exception) {
            log.error("Exception in PropertyManager");
        }
    }
}

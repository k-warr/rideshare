package com.logic;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kien Warren on 5/8/17.
 */
public class DateManipulatorTest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void nextDateTimeMonday() throws Exception {
        log.info("Next Monday: " + DateManipulator.nextDateTime(1, "M"));
    }

    @Test
    public void nextDateTimeTuesday() throws Exception {
        log.info("Next Tuesday: " + DateManipulator.nextDateTime(1, "T"));
    }

}
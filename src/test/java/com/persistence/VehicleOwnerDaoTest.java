//package com.persistence;
//
//import com.entity.User;
//import com.entity.Vehicle;
//import com.entity.VehicleOwner;
//import org.apache.log4j.Logger;
//import org.hibernate.SQLQuery;
//import org.hibernate.Session;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
///**
// * Created by student on 5/7/17.
// */
//public class VehicleOwnerDaoTest {
//    private final Logger log = Logger.getLogger(this.getClass());
//    private UserDao userDao;
//    private VehicleDao vehicleDao;
//    private VehicleOwnerDao vehicleOwnerDao;
//    private User user;
//    private Vehicle vehicle;
//    private VehicleOwner vehicleOwner;
//    private int userId;
//    private int vehicleId;
//    private int vehicleOwnerId;
//
//    @Before
//    public void setUp() throws Exception {
//        userDao = new UserDao();
//        vehicleDao = new VehicleDao();
//        vehicleOwnerDao = new VehicleOwnerDao();
//        vehicle = new Vehicle("test", "Test Model", 3000);
//        vehicleOwner = new VehicleOwner();
//
//        vehicleId = vehicleDao.addVehicleIfDoesntExist(vehicle);
//
//        user = new User();
//        user.setUsername("test");
//        user.setPassword("test");
//        user.setPhone(1);
//        user.setEmail("test@test.com");
//        user.setVehicleOwner(vehicleOwner);
//
//        userId = userDao.addUser(user);
//        log.info("User id: " + userId);
//        if (user == null) {
//            log.info("user == null");
//        }
//        vehicleOwner.setUser(user);
//        vehicleOwner.setVehicle(vehicle);
//        vehicleOwner.setVin(1);
//        vehicleOwner.setInsuranceProvider("Progressive Test");
//        vehicleOwner.setMaxRidersInclDriver(-1);
//        vehicleOwner.setDriversLicense("Test");
//        vehicleOwner.setLicensePlate("Test123");
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        session.beginTransaction();
//        SQLQuery query2 = session.createSQLQuery("DELETE FROM vehicle_owner WHERE max_riders_incl_driver = -1");
//        query2.executeUpdate();
//        SQLQuery query = session.createSQLQuery("DELETE FROM vehicle WHERE make = \'test\'");
//        query.executeUpdate();
//        SQLQuery query3 = session.createSQLQuery("DELETE FROM user WHERE username = \'test\'");
//        query3.executeUpdate();
//
//
//
//        session.getTransaction().commit();
//    }
//
//    @Test
//    public void addVehicleOwner() throws Exception {
//        vehicleOwnerDao.addVehicleOwner(vehicleOwner);
//
//    }
//
//}
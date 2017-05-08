//package com.persistence;
//
//import com.entity.Vehicle;
//import com.entity.VehicleOwner;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateException;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Kien Warren on 5/7/17.
// */
//public class VehicleOwnerDao {
//    private final Logger log = Logger.getLogger(this.getClass());
//
//    public List<VehicleOwner> getAllVehicleOwners() {
//        List<VehicleOwner> vehicleOwners = new ArrayList<VehicleOwner>();
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        vehicleOwners = session.createCriteria(VehicleOwner.class).list();
//        return vehicleOwners;
//    }
//
//    public VehicleOwner getVehicleOwner(int id) {
//        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        VehicleOwner vehicleOwner = (VehicleOwner) session.get(VehicleOwner.class, id);
//        return vehicleOwner;
//    }
//
//    public int addVehicleOwner(VehicleOwner vehicleOwner) {
//        int id = 0;
//        Session session = null;
//        Transaction trans = null;
//        try {
//            session = SessionFactoryProvider.getSessionFactory().openSession();
//            trans = session.beginTransaction();
//            id = (int) session.save(vehicleOwner); // INSERT statement
//            trans.commit();
//        } catch (HibernateException he) {
//            if (trans!=null) trans.rollback();
//            log.error("HibernateException: " + he);
//        } catch (Exception e) {
//            log.error("Exception: " + e.getMessage());
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        vehicleOwner.setVehicleOwnerId(id);
//        return id;
//    }
//
//    public void deleteVehicleOwner(int id) {
//        Session session = null;
//        Transaction trans = null;
//        try {
//            session = SessionFactoryProvider.getSessionFactory().openSession();
//            trans = session.beginTransaction();
//            session.delete(getVehicleOwner(id));
//            trans.commit();
//        } catch (HibernateException he) {
//            log.error("HibernateException: " + he);
//        } catch (Exception e) {
//            log.error("Exception: " + e.getMessage());
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
//
//    public void updateVehicleOwner(VehicleOwner vehicleOwner) {
//        Session session = null;
//        Transaction trans = null;
//
//        try {
//            session = SessionFactoryProvider.getSessionFactory().openSession();
//            trans = session.beginTransaction();
//            session.saveOrUpdate(vehicleOwner);
//            trans.commit();
//
//        } catch (HibernateException he) {
//            log.error("HibernateException: " + he);
//        } catch (Exception e) {
//            log.error("Exception: " + e.getMessage());
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//
//    }
//
//    public boolean existsVehicleOwnerByUserId(int id) {
//        Session session = null;
//        List<VehicleOwner> vehicleOwners = null;
//        try {
//            session = SessionFactoryProvider.getSessionFactory().openSession();
//            Query query = session.createSQLQuery(
//                    "select * from vehicle_owner where user_id = :user_id")
//                    .addEntity(VehicleOwner.class)
//                    .setParameter("user_id", id);
//            vehicleOwners = query.list();
//
//        } catch (HibernateException he) {
//            log.error("HibernateException: " + he);
//        } catch (Exception e) {
//            log.error("Exception: " + e.getMessage());
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        if (vehicleOwners != null && vehicleOwners.size() > 0) {
//            log.info("existsVehicleOwnerByUserId = true");
//            return  true;
//        }
//        log.info("existsVehicleOwnerByUserId = false");
//        return false;
//    }
//}

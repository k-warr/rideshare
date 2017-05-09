package com.persistence;

import com.entity.Vehicle;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kien Warren on 5/7/17.
 */
public class VehicleDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public int addVehicleIfDoesntExist(Vehicle vehicle) {
        int id = existsVehicle(vehicle);
        if (id == -1) {
            id = addVehicle(vehicle);
        }
        return id;
    }

    public int existsVehicle(Vehicle vehicle) {
        Session session = null;
        List<Vehicle> vehicles = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from vehicle where make = :make "
                            + "AND model = :model "
                            + "AND year = :year LIMIT 1")
                    .addEntity(Vehicle.class)
                    .setParameter("make", vehicle.getMake())
                    .setParameter("model", vehicle.getModel())
                    .setParameter("year", vehicle.getYear());
            vehicles = query.list();

        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (vehicles != null && vehicles.size() == 1 ) {
            return  vehicles.get(0).getVehicleId();
        }
        return -1;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> users = new ArrayList<Vehicle>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(Vehicle.class).list();
        return users;
    }

    public Vehicle getVehicle(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Vehicle vehicle = (Vehicle) session.get(Vehicle.class, id);
        return vehicle;
    }

    /**
     * add a vehicle
     *
     * @param vehicle
     * @return the id of the inserted record.
     */
    public int addVehicle(Vehicle vehicle) {
        int id = 0;
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            id = (int) session.save(vehicle); // INSERT statement
            trans.commit();
        } catch (HibernateException he) {
            if (trans!=null) trans.rollback();
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        vehicle.setVehicleId(id);
        return id;
    }

    /**
     * delete a vehicle by id
     * @param id the vehicle's id
     */
    public void deleteVehicle(int id) {
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(getVehicle(id));
            trans.commit();
        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Update the vehicle
     * @param vehicle
     */
    public void updateVehicle(Vehicle vehicle) {
        Session session = null;
        Transaction trans = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            trans.commit();

        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}

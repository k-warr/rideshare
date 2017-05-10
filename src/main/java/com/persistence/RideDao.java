package com.persistence;

import com.entity.Ride;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kien Warren on 4/30/17.
 */
public class RideDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Gets all upcoming rides by user id.
     *
     * @param user_id the user id
     * @return the all upcoming rides by user id
     */
    public List<Ride> getAllUpcomingRidesByUserId(int user_id) {
        List<Ride> rides = new ArrayList<Ride>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Date currentDate = new Date();
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from ride where user_user_id = :user_id "
                    + "AND ride_datetime > :currentDate "
                    + "AND ride_is_full <> 1")
                    .addEntity(Ride.class)
                    .setParameter("user_id", user_id)
                    .setParameter("currentDate", currentDate);
            rides = query.list();

        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (rides != null && rides.size() > 0) {
            return rides;
        }
        return null;
    }

    /**
     * Gets all rides.
     *
     * @return the all rides
     */
    public List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<Ride>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rides = session.createCriteria(Ride.class).list();
        return rides;
    }

    /**
     * Gets ride.
     *
     * @param id the id
     * @return the ride
     */
    public Ride getRide(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Ride ride = (Ride) session.get(Ride.class, id);
        return ride;
    }

    /**
     * Add ride int.
     *
     * @param ride the ride
     * @return the int
     */
    public int addRide(Ride ride) {
        int id = 0;
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            id = (int) session.save(ride); // INSERT statement
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

        ride.setRideId(id);
        return id;
    }

    /**
     * Delete ride.
     *
     * @param id the id
     */
    public void deleteRide(int id) {
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(getRide(id));
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
     * Update ride.
     *
     * @param ride the ride
     */
    public void updateRide(Ride ride) {
        Session session = null;
        Transaction trans = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(ride);
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

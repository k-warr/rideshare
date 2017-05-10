package com.persistence;

import com.entity.Address;
import com.entity.Ride;
import com.entity.RideRequest;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kien Warren on 4/27/17.
 */
public class RideRequestDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Return a list of all rideRequests
     *
     * @return All rideRequests
     */
    public List<RideRequest> getAllRideRequests() {
        List<RideRequest> rideRequests = new ArrayList<RideRequest>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        rideRequests = session.createCriteria(RideRequest.class).list();
        return rideRequests;
    }

    /**
     * Gets ride request.
     *
     * @param id the id
     * @return the ride request
     */
    public RideRequest getRideRequest(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        RideRequest rideRequest = (RideRequest) session.get(RideRequest.class, id);
        return rideRequest;
    }

    /**
     * Gets ride request by user id.
     *
     * @param id the id
     * @return the ride request by user id
     */
    public List<RideRequest> getRideRequestByUserId(int id) {
        List<RideRequest> rideRequests = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from ride_request where user_id = :user_id ")
                    .addEntity(RideRequest.class)
                    .setParameter("user_id", id);
            rideRequests = query.list();
        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return rideRequests;
    }

    /**
     * Gets all open requests exclude user.
     *
     * @param id the id
     * @return the all open requests exclude user
     */
    public List<RideRequest> getAllOpenRequestsExcludeUser(int id) {
        List<RideRequest> rideRequests = null;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "SELECT * FROM ride_request WHERE NOT user_id = :user_id "
                    + "AND request_status = 'Active'")
                    .addEntity(RideRequest.class)
                    .setParameter("user_id", id);
            rideRequests = query.list();
        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return rideRequests;
    }

    /**
     * add a rideRequest
     *
     * @param rideRequest the ride request
     * @return the id of the inserted record.
     */
    public int addRideRequest(RideRequest rideRequest) {
        int id = 0;
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            id = (int) session.save(rideRequest); // INSERT statement
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
        rideRequest.setRequestId(id);
        return id;
    }

    /**
     * delete a rideRequest by id
     *
     * @param id the rideRequest's id
     */
    public void deleteRideRequest(int id) {
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(getRideRequest(id));
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
     * Update the rideRequest
     *
     * @param rideRequest the ride request
     */
    public void updateRideRequest(RideRequest rideRequest) {
        Session session = null;
        Transaction trans = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(rideRequest);
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

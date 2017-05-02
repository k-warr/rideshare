package com.persistence;

import com.entity.Address;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 5/2/17.
 */
public class AddressDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<Address> getAllAddresss() {
        List<Address> addresses = new ArrayList<Address>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        addresses = session.createCriteria(Address.class).list();
        return addresses;
    }

    public Address getAddress(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Address address = (Address) session.get(Address.class, id);
        return address;
    }

    public boolean AddressExists(Address address) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        return false;
    }

    /**
     * add a address
     *
     * @param address
     * @return the id of the inserted record.
     */
    public int addAddress(Address address) {
        int id = 0;
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            id = (int) session.save(address); // INSERT statement
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
        address.setAddressId(id);
        return id;
    }

    /**
     * delete a address by id
     * @param id the address's id
     */
    public void deleteAddress(int id) {
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(getAddress(id));
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
     * Update the address
     * @param address
     */

    public void updateAddress(Address address) {
        Session session = null;
        Transaction trans = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(address);
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

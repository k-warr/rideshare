package com.persistence;

import com.entity.Address;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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

    public int existsAddress(Address address) {
        Session session = null;
        Transaction trans = null;
        List<Address> addresses = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
//            trans = session.beginTransaction();
//            session.delete(getAddress(id));
//            trans.commit();

//            addresses = session.createCriteria(Address.class)
//                    .setProjection(Projections.property())
//                    .add(Restrictions.eq("address_number", address.getAddressNumber()))
//
////                    .add(Restrictions.eq("street_name", address.getStreetName()))
////                    .add(Restrictions.eq("city", address.getCity()))
////                    .add(Restrictions.eq("state", address.getState()))
////                    .add(Restrictions.eq("zip_code", address.getZipCode()))
//                    .list();
            addresses = session.createCriteria(Address.class)
                    .setProjection( Projections.distinct( Projections.projectionList()
                    .add( Projections.property("address_number"), "address_number")))
                    .add(Restrictions.eq("address_number", address.getAddressNumber()))
            .list();
            // TODO: Address this issue - ERROR com.persistence.AddressDao  - HibernateException: org.hibernate.QueryException: could not resolve property: address_number of: com.entity.Address
        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (addresses != null && addresses.size() > 0) {
            log.info(addresses.get(0));
            return  addresses.get(0).getAddressId();
        }
        return -1;
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

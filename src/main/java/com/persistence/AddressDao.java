package com.persistence;

import com.entity.Address;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kien Warren on 5/2/17.
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
        setAddressString(address);
        return id;
    }

    private void setAddressString(Address address) {
        address.setFullAddress(address.getAddressNumber()
                + " " + address.getStreetName()
                + " " + address.getCity()
                + ", " + address.getState()
                + " " + address.getZipCode());
    }

    public String getAddressWebUrlFormat(Address address) {
        return address.getFullAddress().replace(" ", "+");
    }

    public int addAddressIfDoesntExist(Address address) {
        int id = existsAddress(address);
        if (id == -1) {
            id = addAddress(address);
            setAddressString(address);
        }

        return id;
    }

    public int existsAddress(Address address) {
        Session session = null;
        List<Address> addresses = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from address where house_number = :address_number "
                    + "AND street_name = :street_name "
                    + "AND city = :city "
                    + "AND state = :state "
                    + "AND zip_code = :zip_code LIMIT 1")
                    .addEntity(Address.class)
                    .setParameter("address_number", address.getAddressNumber())
                    .setParameter("street_name", address.getStreetName())
                    .setParameter("city", address.getCity())
                    .setParameter("state", address.getState())
                    .setParameter("zip_code", address.getZipCode());
            addresses = query.list();

        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (addresses != null && addresses.size() == 1 ) {
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

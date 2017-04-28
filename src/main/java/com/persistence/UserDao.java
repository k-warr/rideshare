package com.persistence;

import com.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 4/27/17.
 */
public class UserDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    public User getUser(int id) {
//        session = SessionFactoryProvider.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        SQLQuery output = session.createSQLQuery("SELECT * FROM user WHERE username=\'test\'");
//        output.setResultTransformer(Transformers.aliasToBean(User.class));
//        List users =  output.list();
//        // TODO: get return from query to User Object
//        System.out.println(users.get(0));
//        return (User) users.get(0);

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record.
     */
    public int addUser(User user) {
        int id = 0;
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            id = (int) session.save(user); // INSERT statement
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

        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {
        Session session = null;
        Transaction trans = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(getUser(id));
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
     * Update the user
     * @param user
     */

    public void updateUser(User user) {
        Session session = null;
        Transaction trans = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            trans = session.beginTransaction();
            user.setFirstName("test");
            session.saveOrUpdate(user);
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

package com.persistence;

import com.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 4/27/17.
 */
public class UserDao {
    private final Logger log = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    public User getUserByUsername(String username) {
        Session session = null;
        List<User> users = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from user where username = :username LIMIT 1")
                    .addEntity(User.class)
                    .setParameter("username", username);
            users = query.list();

        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (users == null || users.size() != 1 ) {
            return null;
        }
        log.info("user found: " + username);
        return users.get(0);
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
        user.setUserId(id);
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

    public boolean isDriverByUsername(String username) {
        Session session = null;
        List<User> users = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from USER where username = :username LIMIT 1")
                    .addEntity(User.class)
                    .setParameter("username", username);
            users = query.list();

        } catch (HibernateException he) {
            log.error("HibernateException: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        if (users != null && users.size() > 0) {
            log.info("isDriverByUsername = true");
            return  true;
        }
        log.info("isDriverByUsername = false");
        return false;
    }
}

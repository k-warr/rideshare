package com.persistence;

import com.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/26/17.
 */
public class UserDaoTest {
    UserDao dao;
    User testUser;
    private final Logger log = Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new UserDao();
        testUser = new User();
        testUser.setUsername("test");
        testUser.setPassword("test");
        testUser.setEmail("test@test.test");
        testUser.setPhone(1234567890);
        testUser.setIsDriver(0);
    }

    @After
    public void deleteTestUser() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("DELETE FROM user WHERE username = \'test\'");
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Test
    public void isDriverByUsernameTest() throws  Exception {
        testUser.setIsDriver(1);
        dao.addUser(testUser);

        Session session = null;
        List<User> users = null;

        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            Query query = session.createSQLQuery(
                    "select * from user where username = :username LIMIT 1")
                    .addEntity(User.class)
                    .setParameter("username", testUser.getUsername());
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
            assertTrue("isDriverByUsernameTest failed", false);
        } else {
            assertTrue(true);
        }
    }

    @Test
    public void getAUserTest() throws Exception {
        String username = "";
        User returnUser = dao.getUser(1);
        assertEquals("getAUserTest failed","admin", returnUser.getUsername());
    }

    @Test
    public void addUser() throws Exception {
        String username = "";
        int userId = dao.addUser(testUser);

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(
                "select * from user where username = :username LIMIT 1")
                .addEntity(User.class)
                .setParameter("username", "test");
        List<User> users = query.list();

        if (users.size() > 0) {
            assertEquals("addUser failed", userId, users.get(0).getUserId());
        } else {
            assertTrue(false);
        }

    }
}
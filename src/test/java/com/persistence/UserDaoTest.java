package com.persistence;

import com.entity.User;
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

    @Before
    public void setup() {
        dao = new UserDao();
        testUser = new User();
        testUser.setUsername("test");
        testUser.setPassword("test");
        testUser.setEmail("test@test.test");
        testUser.setPhone(1234567890);
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
    public void getAUserTest() throws Exception {
        String username = "";
        dao.addUser(testUser);

        User returnUser = dao.getUser(1);
        System.out.println("----Email: " + returnUser.getEmail());

        assertEquals("getAUserTest failed","test", returnUser.getUsername());
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
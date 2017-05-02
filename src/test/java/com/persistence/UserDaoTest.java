package com.persistence;

import com.entity.User;
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

        SQLQuery output = session.createSQLQuery("SELECT username as Username FROM user WHERE username=\'test\'");
        List<String> users = output.list();

        if (users.size() > 0) {
            username = users.get(0);
        }

        assertEquals("addUser failed","test", username);
    }

    @After
    public void deleteTestUser() {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("DELETE FROM user WHERE username = \'test\'");
        query.executeUpdate();
        session.getTransaction().commit();
    }
}
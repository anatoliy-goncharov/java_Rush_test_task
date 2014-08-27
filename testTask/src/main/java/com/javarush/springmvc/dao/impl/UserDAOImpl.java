package com.javarush.springmvc.dao.impl;

import com.javarush.springmvc.dao.UserDAO;
import com.javarush.springmvc.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anatoliy_Goncharov on 21.08.2014.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int insertRow(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        return (Integer) id;
    }

    @Override
    public List<User> getSearchList(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from User where name like :name").addEntity(User.class);
        query.setString("name", "%" + name + "%");
        @SuppressWarnings("unchecked")
        List<User> searchList = query.list();
        session.close();
        return searchList;
    }

    @Override
    public List<User> getList() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<User> usersList = session.createQuery("from User").list();
        session.close();
        return usersList;
    }

    @Override
    public User getRowById(int id) {
        Session session = sessionFactory.openSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public int updateRow(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        Serializable id = session.getIdentifier(user);
        session.close();
        return (Integer) id;
    }

    @Override
    public int deleteRow(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.delete(user);
        tx.commit();
        Serializable ids = session.getIdentifier(user);
        session.close();
        return (Integer) ids;
    }
}

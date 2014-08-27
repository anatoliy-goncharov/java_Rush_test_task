package com.javarush.springmvc.services.impl;

import com.javarush.springmvc.dao.UserDAO;
import com.javarush.springmvc.domain.User;
import com.javarush.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Anatoliy_Goncharov on 21.08.2014.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public int insertRow(User user) {
        return userDAO.insertRow(user);
    }

    @Override
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    public List<User> getSearchList(String name){
        return userDAO.getSearchList(name);
    }

    @Override
    public User getRowById(int id) {
        return userDAO.getRowById(id);
    }

    @Override
    public int updateRow(User user) {
        return userDAO.updateRow(user);
    }

    @Override
    public int deleteRow(int id) {
        return userDAO.deleteRow(id);
    }
}

package com.javarush.springmvc.dao;

import com.javarush.springmvc.domain.User;

import java.util.List;

/**
 * Created by Anatoliy_Goncharov on 21.08.2014.
 */
public interface UserDAO {

    public int insertRow(User user);

    public List<User> getList();

    public List<User> getSearchList(String name);

    public User getRowById(int id);

    public int updateRow(User User);

    public int deleteRow(int id);
}
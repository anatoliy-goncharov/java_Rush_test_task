package com.javarush.springmvc.services;

import com.javarush.springmvc.domain.User;

import java.util.List;

public interface UserService {

    public int insertRow(User user);

    public List<User> getList();

    public List<User> getSearchList(String name);

    public User getRowById(int id);

    public int updateRow(User user);

    public int deleteRow(int id);
}

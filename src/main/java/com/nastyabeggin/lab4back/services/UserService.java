package com.nastyabeggin.lab4back.services;

import com.nastyabeggin.lab4back.beans.UserBean;

import java.util.List;

public interface UserService {

    UserBean saveUser(UserBean user);
    UserBean getUser(String username);
    List<UserBean> getAllUsers();

}

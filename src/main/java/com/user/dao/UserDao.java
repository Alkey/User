package com.user.dao;

import com.user.model.User;
import java.util.List;

public interface UserDao {

    public void add(User user);

    List<User> listUsers();
}

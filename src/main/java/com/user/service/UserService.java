package com.user.service;

import com.user.model.User;
import java.util.List;

public interface UserService {

    void add(User user);

    List<User> listUsers();
}

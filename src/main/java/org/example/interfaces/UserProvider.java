package org.example.interfaces;

import org.example.model.User;

public interface UserProvider {
    void addUser(User user);
    String getList();
}

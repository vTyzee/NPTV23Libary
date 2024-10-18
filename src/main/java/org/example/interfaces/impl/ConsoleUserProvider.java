package org.example.interfaces.impl;

import org.example.interfaces.UserProvider;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUserProvider implements UserProvider {
    private final List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println("Пользователь добавлен: " + user);
    }

    @Override
    public String getList() {
        StringBuilder userList = new StringBuilder();
        for (User user : users) {
            userList.append(user.toString()).append("\n");
        }
        return userList.toString();
    }
}

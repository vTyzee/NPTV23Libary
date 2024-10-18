package org.example.Services;

import org.example.interfaces.UserProvider;
import org.example.interfaces.Input;
import org.example.model.User;

public class UserService {
    private final UserProvider userProvider;

    public UserService(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    // Метод для управления пользователями
    public void manageUsers(Input input) {
        boolean repeat = true;
        do {
            System.out.println("Управление читателями:");
            System.out.println("1. Добавить нового читателя");
            System.out.println("2. Вывести список читателей");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Введите номер задачи: ");

            int task;
            try {
                task = Integer.parseInt(input.getInput());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
                continue;
            }

            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    String userName = input.getInput();
                    System.out.print("Введите email пользователя: ");
                    String userEmail = input.getInput();
                    User user = new User(userName, userEmail);
                    userProvider.addUser(user); // Добавление пользователя
                    break;
                case 2:
                    System.out.println("----- Список читателей -----");
                    System.out.println(userProvider.getList()); // Вывод списка пользователей
                    break;
                default:
                    System.out.println("Неверный номер задачи.");
                    break;
            }
        } while (repeat);
    }

    public void addUser(User user) {
        userProvider.addUser(user);
    }

    public String printListUsers() {
        return userProvider.getList();
    }
}

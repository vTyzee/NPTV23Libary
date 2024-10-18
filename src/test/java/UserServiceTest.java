package org.example;

import org.example.Services.UserService;
import org.example.interfaces.Input;
import org.example.interfaces.UserProvider;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;
    private UserProvider userProviderMock;
    private Input inputMock;

    @BeforeEach
    public void setUp() {
        // Создаем моки для зависимостей
        userProviderMock = Mockito.mock(UserProvider.class);
        inputMock = Mockito.mock(Input.class);

        // Инициализируем UserService с моками
        userService = new UserService(userProviderMock);
    }

    @Test
    public void testAddUser() {
        // Мокаем ввод данных пользователя
        when(inputMock.getInput()).thenReturn("John Doe", "john@example.com");

        // Выполняем добавление пользователя
        userService.manageUsers(inputMock);

        // Проверяем, что метод addUser был вызван с правильными данными
        verify(userProviderMock, times(1)).addUser(any(User.class));
    }

    @Test
    public void testPrintListUsers() {
        // Мокаем вывод списка пользователей
        when(userProviderMock.getList()).thenReturn("User1, User2");

        // Вызываем метод для вывода списка пользователей
        String users = userService.printListUsers();

        // Проверяем, что вывод был успешным
        assert users.equals("User1, User2");

        // Проверяем, что метод getList был вызван
        verify(userProviderMock, times(1)).getList();
    }

    @Test
    public void testManageUsers() {
        // Мокаем последовательность ввода для управления пользователями
        when(inputMock.getInput()).thenReturn("1", "Jane Doe", "jane@example.com", "0");

        // Выполняем управление пользователями
        userService.manageUsers(inputMock);

        // Проверяем, что пользователь был добавлен
        verify(userProviderMock, times(1)).addUser(any(User.class));
    }
}

package service;

import entity.User;

import java.util.List;

public interface UserService {
    boolean register(User user);

    List<User> getAll();

    boolean login(String username, String password);
}

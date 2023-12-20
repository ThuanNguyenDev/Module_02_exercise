package service.impl;

import entity.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServieImpl implements UserService {
    List<User> userList = new ArrayList<User>();
    @Override
    public boolean register(User user) {
        userList.add(user);
        return true;
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public boolean login(String username, String password) {
        for(User element : userList){
            if(element.getUsername() == username &&
                element.getPassword() == password){
                return true;
            }
        }
        return false;
    }
}

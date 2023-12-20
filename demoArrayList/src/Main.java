import entity.User;
import service.UserService;
import service.impl.UserServieImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User(1, "tien", "tiendeptrai");

        UserService userService = new UserServieImpl();
        boolean success = userService.register(user);

        List<User> userList = userService.getAll();
        System.out.println(userList);
        login();
    }

    private static void login(){
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        UserService userService = new UserServieImpl();
        boolean success = userService.login(username, password);
        if(success){
            System.out.println("Login success");
        } else {
            System.out.println("wrong pass");
        }
    }



}
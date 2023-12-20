package repository;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public List<User> getAllUsers() {
        String query = "select * from user";
        List<User> userList = new ArrayList<>();

        try {
            conn = ConnectionConfig.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.println(", Username: " + rs.getString("USER_NAME"));
                System.out.println(", Password: " + rs.getString("PASSWORD"));
                System.out.print(", First Name: " + rs.getString("FIRST_NAME"));
                System.out.print(", Last Name: " + rs.getString("LAST_NAME"));
                System.out.println(", Email: " + rs.getString("EMAIL"));
                System.out.println(", Phone Number: " + rs.getString("PHONE_NUMBER"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        List<User> list = userRepository.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }
    }
}

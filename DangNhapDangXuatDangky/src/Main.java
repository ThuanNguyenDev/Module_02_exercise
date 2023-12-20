
public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "password");

        // Đăng ký
        String username = "admin";
        String password = "password";
        user.login(username, password);

        // Thử đăng nhập với thông tin sai
        String wrongUsername = "user";
        String wrongPassword = "123456";
        user.login(wrongUsername, wrongPassword);

        // Đăng xuất
        user.logout();
    }
}
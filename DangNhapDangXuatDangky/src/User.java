public class User {
    private final String username;
    private final String password;
    private boolean isLoggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.isLoggedIn = true;
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Sai tên đăng nhập hoặc mật khẩu!");
        }
    }

    public void logout() {
        if (isLoggedIn) {
            this.isLoggedIn = false;
            System.out.println("Đăng xuất thành công!");
        } else {
            System.out.println("Chưa đăng nhập!");
        }
    }


}

package Entities;

public class Customer {
    private int idCustomer;
    private String username;
    private String password;

    public Customer(int idCustomer, String username, String password) {
        this.idCustomer = idCustomer;
        this.username = username;
        this.password = password;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

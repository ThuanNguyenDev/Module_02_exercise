package Entities;
import Entities.Customer;
public class Cart {
    private int idCart;
    private Customer idCustomer;

    public Cart(int idCart, Customer idCustomer) {
        this.idCart = idCart;
        this.idCustomer = idCustomer;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }
}

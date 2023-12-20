package Entities;
import java.util.List;
public class Cart {
    private int cartID;
    private Customer customer;
    private List<CartLine> customerCart;
    public Cart(int cartID,Customer customer, List<CartLine> customerCart) {
        this.cartID = cartID;
        this.customer = customer;
        this.customerCart = customerCart;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartLine> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(List<CartLine> customerCart) {
        this.customerCart = customerCart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartID=" + cartID +
                ", customer=" + customer +
                ", customerCart=" + customerCart +
                '}';
    }
}

package Entities;
import java.util.List;
import java.time.LocalDateTime;

public class Order {
    private int orderID;
    private LocalDateTime orderDateTime;
    private Customer customer;
    private List<CartLine> cart;
    private double totalPrice;
    private String statusOrder;

    public Order(int orderID, LocalDateTime orderDateTime, Customer customer, List<CartLine> cart, double totalPrice,String statusOder) {
        this.orderID = orderID;
        this.orderDateTime = orderDateTime;
        this.customer = customer;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.statusOrder = statusOder;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartLine> getCart() {
        return cart;
    }

    public void setCart(List<CartLine> cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderDateTime=" + orderDateTime +
                ", customer=" + customer +
                ", cart=" + cart +
                ", totalPrice=" + totalPrice +
                ", statusOrder='" + statusOrder + '\'' +
                '}';
    }
}


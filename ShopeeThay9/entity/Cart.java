package entity;

import java.util.List;

public class Cart {

    private int id;

    private int customerId;

    private List<CartLineItem> cartLineItemList;

    private long totalPrice;

    private static int count;


    public Cart(int customerId, List<CartLineItem> cartLineItemList, long totalPrice) {
        this.id = count;
        count++;
        this.customerId = customerId;
        this.cartLineItemList = cartLineItemList;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<CartLineItem> getCartLineItemList() {
        return cartLineItemList;
    }

    public void setCartLineItemList(List<CartLineItem> cartLineItemList) {
        this.cartLineItemList = cartLineItemList;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", cartLineItemList=" + cartLineItemList +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

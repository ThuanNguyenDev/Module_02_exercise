package Entities;

public class Cartline {
    private int idCartline;
    private Product idProduct;
    private Cart idCart;
    private int quantity;
    private Product totalPrice;

    public Cartline(int idCartline, Product idProduct, Cart idCart, int quantity, Product totalPrice) {
        this.idCartline = idCartline;
        this.idProduct = idProduct;
        this.idCart = idCart;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getIdCartline() {
        return idCartline;
    }

    public void setIdCartline(int idCartline) {
        this.idCartline = idCartline;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Cart getIdCart() {
        return idCart;
    }

    public void setIdCart(Cart idCart) {
        this.idCart = idCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Product totalPrice) {
        this.totalPrice = totalPrice;
    }
}

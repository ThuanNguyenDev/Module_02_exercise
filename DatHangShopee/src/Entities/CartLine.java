package Entities;
import java.util.List;

public class CartLine {
    private Product product;
    private List<String> sizes;
    private List<String> colors;
    private int orderProductQuantity;
    private double subtotalPrice;

    public CartLine(Product product, List<String> sizes, List<String> colors, int orderProductQuantity, double subtotalPrice) {
        this.product = product;
        this.sizes = sizes;
        this.colors = colors;
        this.orderProductQuantity = orderProductQuantity;
        this.subtotalPrice = subtotalPrice;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public int getOrderProductQuantity() {
        return orderProductQuantity;
    }

    public void setOrderProductQuantity(int orderProductQuantity) {
        this.orderProductQuantity = orderProductQuantity;
    }

    public double getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(double subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                ", product=" + product +
                ", sizes=" + sizes +
                ", colors=" + colors +
                ", orderProductQuantity=" + orderProductQuantity +
                ", subtotalPrice=" + subtotalPrice +
                '}';
    }
}

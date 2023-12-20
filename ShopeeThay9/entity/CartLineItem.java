package entity;

public class CartLineItem {

    private int id;

    private int productId;

    private int quantity;

    private long subTotalPrice;

    private static int count;

    public CartLineItem( int productId, int quantity, long subTotalPrice) {
        this.id = count;
        count ++;
        this.productId = productId;
        this.quantity = quantity;
        this.subTotalPrice = subTotalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(long subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }
}

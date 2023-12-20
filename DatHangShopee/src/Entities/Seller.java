package Entities;
public class Seller {
    private int sellerID;
    private String sellerPassword;
    private String sellerName;
    private int storeID;

    public Seller(int sellerID, String sellerPassword, String sellerName, int storeID) {
        this.sellerID = sellerID;
        this.sellerPassword = sellerPassword;
        this.sellerName = sellerName;
        this.storeID = storeID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerID=" + sellerID +
                ", sellerPassword='" + sellerPassword + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", storeID=" + storeID +
                '}';
    }
}

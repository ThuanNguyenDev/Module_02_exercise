package Entities;
public class Store  {
    private int storeID;
    private String storeName;
    private int ownerID;
    private String address;

    public Store(int storeID, String storeName, int ownerID, String address) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.ownerID = ownerID;
        this.address = address;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeID=" + storeID +
                ", storeName='" + storeName + '\'' +
                ", ownerID=" + ownerID +
                ", address='" + address + '\'' +
                '}';
    }
}

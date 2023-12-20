package Entities;
public class Owner {
    private int ownerID;
    private String ownerPassword;
    private String ownerName;

    public Owner(int ownerID, String ownerPassword, String ownerName) {
        this.ownerID = ownerID;
        this.ownerPassword = ownerPassword;
        this.ownerName = ownerName;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerID +
                ", ownerPassword='" + ownerPassword + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}

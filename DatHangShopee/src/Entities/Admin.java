package Entities;
public class Admin {
    private int adminID;
    private String adminPassword;
    private String adminName;

    public Admin(int adminID, String adminPassword, String adminName) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}

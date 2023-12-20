package Service;
import Entities.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AdminService  implements Serializable {
    static List<Admin> adminList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void register() {
        displayAdminList();
        boolean registrationComplete = false;

        do {
            try {
                System.out.print("Enter admin ID: ");
                int adminID = Integer.parseInt(scanner.nextLine());

                boolean accountExists = false;
                for (Admin admin : adminList) {
                    if (admin.getAdminID() == adminID) {
                        accountExists = true;
                        break;
                    }
                }

                if (accountExists) {
                    System.out.println("Admin ID already exists. Please choose a different ID.");
                } else {
                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    System.out.print("Enter admin name: ");
                    String adminName = scanner.nextLine();

                    Admin newAdmin = new Admin(adminID, adminPassword, adminName);
                    adminList.add(newAdmin);
                    writeAdminToFile();
                    System.out.println("Admin successfully registered");
                    System.out.println("Log in System now !!!");
                    loginAndManageSystem();

                    registrationComplete = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid admin ID. Please enter a valid numeric ID.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!registrationComplete);
    }

    public static void writeAdminToFile() throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("Admin.csv"));

            for (Admin admin : adminList) {
                String adminLine = admin.getAdminID() + "," + admin.getAdminPassword() + "," + admin.getAdminName();
                writer.write(adminLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing admin data: " + e.getMessage());
            throw e;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while closing the writer: " + e.getMessage());
                }
            }
        }
    }

    public static void displayAdminList() {
        System.out.println("Admin List:");
        if (adminList.isEmpty()) {
            System.out.println("No Stores available.");
        } else {
            for (Admin admin : adminList) {
                System.out.println("Admin ID: " + admin.getAdminID());
                System.out.println("Admin Name: " + admin.getAdminName());
                System.out.println("---------------------------");
            }
        }
    }

    public static void loginAndManageSystem() throws IOException {
        displayAdminList();

        System.out.println("Enter Admin ID: ");
        int adminID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Admin password: ");
        String adminPassword = scanner.nextLine();

        Admin loggedInAdmin = null;

        for (Admin admin : adminList) {
            if (admin.getAdminID() == adminID && admin.getAdminPassword().equals(adminPassword)) {
                loggedInAdmin = admin;
                break;
            }
        }

        if (loggedInAdmin != null) {
            System.out.println("Logged in successfully! ");
            manageSystem(loggedInAdmin.getAdminID());
        } else {
            System.out.println("Admin ID and password do not match/exist");
            main(null);
        }
    }

    public static void manageSystem(int adminID) {
        displayAdminList();

        Admin admin = null;
        for (Admin a : adminList) {
            if (a.getAdminID() == adminID) {
                admin = a;
                break;
            }
        }

        if (admin != null) {
            while (true) {
                System.out.println("Welcome " + admin.getAdminName() + " to the system!");
                System.out.println("Please choose one of the following options:");
                System.out.println("1. Account Information Management");
                System.out.println("2. View Customer List");
                System.out.println("3. View Seller List");
                System.out.println("4. View Store List");
                System.out.println("5. View Owner List");
                System.out.println("6. Create Category");
                System.out.println("7. View Category");
                System.out.println("8. Update Category");
                System.out.println("9. Delete Category");
                System.out.println("10. Back");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            adminAccountManagement();
                            break;
                        case 2:
                            CustomerService.displayCustomerList();
                            break;
                        case 3:
                            SellerService.displaySellerList();
                            break;
                        case 4:
                            StoreService.displayStoreList();
                            break;
                        case 5:
                            OwnerService.displayOwnerList();
                            break;
                        case 6:
                            CategoryService.addCategory();
                            break;
                        case 7:
                            CategoryService.displayCategories();
                            break;
                        case 8:
                            CategoryService.updateCategory();
                            break;
                        case 9:
                            CategoryService.deleteCategory();
                            break;
                        case 10:
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } else {
            System.out.println("Invalid Admin ID. Access denied.");
        }
    }
    public static void adminAccountManagement() {
        displayAdminList();

        System.out.println("Enter Admin ID to be checked: ");
        int checkAdminID = Integer.parseInt(scanner.nextLine());

        try {
            boolean adminFound = false;

            for (Admin admin : adminList) {
                if (admin.getAdminID() == checkAdminID) {
                    System.out.println(admin);
                    System.out.println("ADMIN ACCOUNT SETTING");
                    System.out.println("1. Change password");
                    System.out.println("2. Change name");
                    System.out.println("3. Change ID");
                    System.out.println("4. Back");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1 : {
                            System.out.println("Enter Admin old password:");
                            String oldPass = scanner.nextLine();
                            if (admin.getAdminPassword().equals(oldPass)) {
                                System.out.println("Enter new password: ");
                                String newPass = scanner.nextLine();
                                admin.setAdminPassword(newPass);
                                System.out.println("Password changed successfully");
                                writeAdminToFile();
                            } else {
                                System.out.println("Invalid old password");
                            }
                            break;
                        }
                        case 2 : {
                            System.out.println("Enter new name: ");
                            String newName = scanner.nextLine();
                            admin.setAdminName(newName);
                            System.out.println("Name changed successfully");
                            writeAdminToFile();
                            break;
                        }
                        case 3 : {
                            System.out.println("Enter new ID: ");
                            int newID = Integer.parseInt(scanner.nextLine());
                            admin.setAdminID(newID);
                            System.out.println("ID changed successfully");
                            writeAdminToFile();
                            break;
                        }
                        case 4 :
                            loginAndManageSystem();
                            break;
                        default :
                            System.out.println("Invalid Option");
                            break;
                    }

                    loginAndManageSystem();
                    return;
                }
            }

            if (!adminFound) {
                System.out.println("No such Admin");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric value for ID.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing admin data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public static void readAdminFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Admin.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] adminData = line.split(",");
                String adminIDStr = adminData[0];
                if (isInteger(adminIDStr)) {
                    int adminID = Integer.parseInt(adminIDStr);
                    String adminPassword = adminData[1];
                    String adminName = adminData[2];

                    Admin admin = new Admin(adminID, adminPassword, adminName);
                    adminList.add(admin);
                } else {
                    System.out.println("Invalid admin ID: " + adminIDStr);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading admin data: " + e.getMessage());
        }
    }
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            int choice;
            while (true) {
                System.out.println("We have the following options:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        loginAndManageSystem();
                        break;
                    case 3:
                        System.out.println("Exiting....");
                        return;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
package Service;

import Entities.Seller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellerService  implements Serializable {
    static List<Seller> sellerList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void register() {
        displaySellerList();
        boolean registrationComplete = false;

        do {
            try {
                System.out.print("Enter seller ID: ");
                int sellerID = Integer.parseInt(scanner.nextLine());

                boolean accountExists = false;
                for (Seller seller : sellerList) {
                    if (seller.getSellerID() == sellerID) {
                        accountExists = true;
                        break;
                    }
                }

                if (accountExists) {
                    System.out.println("Seller ID already exists. Please choose a different ID.");
                } else {
                    System.out.print("Enter seller password: ");
                    String sellerPassword = scanner.nextLine();

                    System.out.print("Enter seller name: ");
                    String sellerName = scanner.nextLine();

                    System.out.println("Enter store ID");
                    int storeID = Integer.parseInt(scanner.nextLine());

                    Seller newSeller = new Seller(sellerID, sellerPassword, sellerName,storeID);
                    sellerList.add(newSeller);
                    writeSellerToFile();
                    System.out.println("Seller successfully registered");
                    sellerLoginAndManageSystem();

                    registrationComplete = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid seller ID. Please enter a valid numeric ID.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!registrationComplete);
    }


    public static void writeSellerToFile() {
        File sellerFile = new File("Seller.csv");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(sellerFile))) {
            for (Seller seller : sellerList) {
                String sellerData = seller.getSellerID() + "," + seller.getSellerPassword() + "," + seller.getSellerName();
                writer.write(sellerData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sellerLoginAndManageSystem() throws IOException {
        displaySellerList();
        System.out.println("Enter Seller ID: ");
        int sellerID = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Seller password: ");
        String sellerPassword = scanner.nextLine();

        Seller loggedSeller = null;

        for ( Seller seller : sellerList) {
            if(seller.getSellerID()==sellerID && seller.getSellerPassword().equals(sellerPassword)) {
                loggedSeller = seller;
            }
        }

        if (loggedSeller !=null) {
            System.out.println("Logged in successfully!");
            sellerManageSystem(sellerID);
        } else {
            System.out.println("Seller ID and password do not match/exist");
            main(null);
        }
    }

    public static void sellerManageSystem(int sellerID) throws IOException {
        Seller seller = null;
        for (Seller sel : sellerList) {
            if (sel.getSellerID() == sellerID) {
                seller = sel;
                break;
            }
        }

        if (seller != null) {
            while (true) {
                System.out.println("Welcome " + seller.getSellerName() + " to our system!");
                System.out.println("Please choose one of the following options:");
                System.out.println("1.  Seller Account Management");
                System.out.println("2.  View all products");
                System.out.println("3.  Search Product");
                System.out.println("4.  Create Product");
                System.out.println("5.  Update Product");
                System.out.println("6.  Delete Product");
                System.out.println("7.  Store Rent");
                System.out.println("8.  Check Order Detail");
                System.out.println("9.  Accept Order Request");
                System.out.println("10. Checking Customer Order History");
                System.out.println("11. Back");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            sellerAccountManagement();
                            break;
                        case 2:
                            ProductService.viewAllProducts();
                            break;
                        case 3:
                            ProductService.searchProductByID();
                            break;
                        case 4:
                            ProductService.addProduct();
                            break;
                        case 5:
                            ProductService.updateProduct();
                            break;
                        case 6:
                            ProductService.deleteProduct();
                            break;
                        case 7:
                            StoreService.processRentPayment();
                            break;
                        case 8:
                            OrderService.checkOrderDetail();
                            break;
                        case 9:
                            OrderService.acceptOrderRequest();
                            break;
                        case 10:
                            OrderService.viewOrderHistory();
                            break;
                        case 11:
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 11.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } else {
            System.out.println("Seller not found.");
        }
    }
    public static void sellerAccountManagement() throws IOException {
        displaySellerList();
        System.out.println("Enter Seller ID to be checked:");
        int checkSellerID = Integer.parseInt(scanner.nextLine());

        for (Seller seller : sellerList) {
            if (seller.getSellerID() == checkSellerID) {
                System.out.println(seller);
                System.out.println("Account management information as the following:");
                System.out.println("1. Change Password");
                System.out.println("2. Change Name");
                System.out.println("3. Back");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter your old password:");
                        String oldPass = scanner.nextLine();

                        if (seller.getSellerPassword().equals(oldPass)) {
                            System.out.println("Enter your new password: ");
                            String newPass = scanner.nextLine();
                            seller.setSellerPassword(newPass);
                            System.out.println("Password changed successfully!");
                            writeSellerToFile();
                        } else {
                            System.out.println("Invalid old password");
                        }
                        break;

                    case 2:
                        System.out.println("Enter your new name:");
                        String newName = scanner.nextLine();
                        seller.setSellerName(newName);
                        System.out.println("Name changed successfully!");
                        writeSellerToFile();
                        break;

                    case 3:
                        sellerLoginAndManageSystem();
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

                sellerLoginAndManageSystem();
                return;
            }
        }

        System.out.println("No such Seller");
    }

    public static void readSellerFromFile() {
        File sellerFile = new File("Seller.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(sellerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] sellerData = line.split(",");
                if (sellerData.length == 4) {
                    int sellerID = Integer.parseInt(sellerData[0]);
                    String sellerPassword = sellerData[1];
                    String sellerName = sellerData[2];
                    int storeID = Integer.parseInt(sellerData[3]);

                    Seller seller = new Seller(sellerID, sellerPassword, sellerName,storeID);
                    sellerList.add(seller);
                } else {
                    System.out.println("Invalid seller data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void displaySellerList() {
        System.out.println("Seller List:");
        if (sellerList.isEmpty()) {
            System.out.println("No Sellers available.");
        } else {
            for (Seller seller : sellerList) {
                System.out.println(seller.getSellerID() + "-" + seller.getSellerName());
            }
        }
    }

    public static void addSeller() {
        displaySellerList();

        System.out.print("Enter Seller ID: ");
        int sellerID = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Seller Name: ");
        String sellerName = scanner.nextLine();

        System.out.print("Enter Seller Password: ");
        String sellerPassword = scanner.nextLine();

        System.out.println("Enter Store ID: ");
        int storeID = Integer.parseInt(scanner.nextLine());

        Seller newSeller = new Seller(sellerID, sellerName, sellerPassword,storeID);
        sellerList.add(newSeller);

        System.out.println("Seller successfully added.");
        writeSellerToFile();
    }

    public static void removeSeller() {
        displaySellerList();

        System.out.print("Enter Seller ID to remove: ");
        int sellerID = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (Seller seller : sellerList) {
            if (seller.getSellerID() == sellerID) {
                sellerList.remove(seller);
                found = true;
                System.out.println("Seller with ID " + sellerID + " successfully removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Seller with ID " + sellerID + " not found.");
        }
        writeSellerToFile();
    }

    public static void main(String[] args) {
        try {


            int choice;
            boolean exit = false;

            do {
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
                        sellerLoginAndManageSystem();
                        break;
                    case 3:
                        System.out.println("Exiting ......");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid Choice. Please try again.");
                        break;
                }
            } while (!exit);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
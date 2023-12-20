package Service;
import Entities.Owner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OwnerService  implements Serializable {
    static Scanner scanner = new Scanner(System.in);
    static List<Owner> ownerList = new ArrayList<>();
    public static void Register() {
        displayOwnerList();
        boolean registrationComplete = false;

        do {
            try {
                System.out.print("Enter owner ID: ");
                int ownerID = Integer.parseInt(scanner.nextLine());

                boolean accountExists = false;
                for (Owner owner : ownerList) {
                    if (owner.getOwnerID() == ownerID) {
                        accountExists = true;
                        break;
                    }
                }

                if (accountExists) {
                    System.out.println("Owner ID already exists. Please choose a different ID.");
                } else {
                    System.out.print("Enter owner password: ");
                    String ownerPassword = scanner.nextLine();
                    System.out.print("Enter owner name: ");
                    String ownerName = scanner.nextLine();

                    Owner newOwner = new Owner(ownerID, ownerPassword, ownerName);
                    ownerList.add(newOwner);
                    writeOwnerToFile();
                    System.out.println("Owner successfully registered");
                    ownerLoginAndManageSystem();

                    registrationComplete = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid owner ID. Please enter a valid numeric ID.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to file: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!registrationComplete);
    }


    public static void writeOwnerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Owner.csv"))) {
            for (Owner owner : ownerList) {
                String ownerData = owner.getOwnerID() + "," + owner.getOwnerPassword() + "," + owner.getOwnerName();
                writer.write(ownerData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing owner data: " + e.getMessage());
        }
    }

    public static void ownerLoginAndManageSystem() throws Exception {
        displayOwnerList();

        System.out.print("Enter owner ID: ");
        int ownerID = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter owner password: ");
        String ownerPassword = scanner.nextLine();

        boolean loggedIn = false;

        for (Owner owner : ownerList) {
            if (owner.getOwnerID() == ownerID && owner.getOwnerPassword().equals(ownerPassword)) {
                loggedIn = true;
                break;
            }
        }

        if (loggedIn) {
            System.out.println("Logged in successfully!");
            ownerManageSystem(ownerID);
        } else {
            System.out.println("Owner ID and password do not match/exist");
            main(null);
        }
    }

    public static void ownerManageSystem(int ownerID) throws Exception {
        displayOwnerList();
        Owner selectedOwner = null;
        for (Owner owner : ownerList) {
            if (owner.getOwnerID() == ownerID) {
                selectedOwner = owner;
                break;
            }
        }

        if (selectedOwner != null) {
            while (true) {
                System.out.println("Welcome " + selectedOwner.getOwnerName() + " to our shopping system!");
                System.out.println("Please choose one of the following options:");
                System.out.println("1. Owner Account Management");
                System.out.println("2. Add Seller");
                System.out.println("3. Remove Seller");
                System.out.println("4. Create Store");
                System.out.println("5. Update Store");
                System.out.println("6. Delete Store");
                System.out.println("7. Back");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            ownerAccountManagement();
                            break;
                        case 2:
                            SellerService.addSeller();
                            break;
                        case 3:
                            SellerService.removeSeller();
                            break;
                        case 4:
                            StoreService.registerStore();
                            break;
                        case 5:
                            StoreService.updateStore();
                            break;
                        case 6:
                            StoreService.deleteStore();
                            break;
                        case 7:
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } else {
            System.out.println("Owner not found.");
        }
    }
    public static void ownerAccountManagement() throws Exception {
        displayOwnerList();

        System.out.println("Enter owner ID:");
        int checkOwnerID = Integer.parseInt(scanner.nextLine());

        for (Owner owner : ownerList) {
            if (owner.getOwnerID() == checkOwnerID) {
                System.out.println(owner);
                System.out.println("Account management information as the following : ");
                System.out.println("1. Change Password");
                System.out.println("2. Change Name");
                System.out.println("3. Back");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter your old password: ");
                        String oldPass = scanner.nextLine();

                        if (owner.getOwnerPassword().equals(oldPass)) {
                            System.out.println("Enter your new password: ");
                            String newPass = scanner.nextLine();
                            owner.setOwnerPassword(newPass);
                            System.out.println("Password changed successfully !");
                            writeOwnerToFile();
                        } else {
                            System.out.println("Invalid old password");
                        }
                        break;

                    case 2:
                        System.out.println("Enter your new name: ");
                        String newName = scanner.nextLine();
                        owner.setOwnerName(newName);
                        System.out.println("Name changed successfully !");
                        writeOwnerToFile();
                        break;

                    case 3:
                        ownerLoginAndManageSystem();
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }

                ownerLoginAndManageSystem();
                return;
            }
        }

        System.out.println("No such Owner");
    }


    public static void displayOwnerList() {
        System.out.println("Owner List:");
        if (ownerList.isEmpty()) {
            System.out.println("No Owners available.");
        } else {
            for (Owner owner : ownerList) {
                System.out.println(owner.getOwnerID() + "-" + owner.getOwnerName());
            }
        }
    }

    public static void readOwnerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Owner.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] ownerData = line.split(",");
                if (ownerData.length == 3) {
                    int ownerID = Integer.parseInt(ownerData[0]);
                    String ownerPassword = ownerData[1];
                    String ownerName = ownerData[2];

                    Owner owner = new Owner(ownerID, ownerPassword, ownerName);
                    ownerList.add(owner);
                } else {
                    System.out.println("Invalid owner data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading owner data: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        try {


            int choice;
            do {
                System.out.println("We have the following options:");
                System.out.println("1. Register");
                System.out.println("2. Log In");
                System.out.println("3. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        Register();
                        break;
                    case 2:
                        ownerLoginAndManageSystem();
                        break;
                    case 3:
                        System.out.println("Exiting....");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } while (choice !=3);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
package Service;

import Entities.Store;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Service.SellerService.sellerManageSystem;

public class StoreService  implements Serializable {
    static List<Store> storeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void registerStore() {
        displayStoreList();
        try {
            System.out.print("Enter Store ID: ");
            int storeID = Integer.parseInt(scanner.nextLine());

            boolean storeExists = false;
            for (Store store : storeList) {
                if (store.getStoreID() == storeID) {
                    storeExists = true;
                    break;
                }
            }

            if (storeExists) {
                System.out.println("Store ID already exists. Please choose a different ID.");
            } else {
                System.out.print("Enter Store name: ");
                String storeName = scanner.nextLine();

                System.out.print("Enter Owner name: ");
                int storeOwnerID = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter Store address: ");
                String storeAddress = scanner.nextLine();

                Store newStore = new Store(storeID, storeName, storeOwnerID, storeAddress);
                storeList.add(newStore);
                writeStoreToFile();
                System.out.println("Store successfully registered");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric value for ID.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }


    public static void writeStoreToFile() {
        File storeFile = new File("Store.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(storeFile))) {
            for (Store store : storeList) {
                writer.write(store.getStoreID() + ",");
                writer.write(store.getStoreName() + ",");
                writer.write(store.getOwnerID() + ",");
                writer.write(store.getAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStoreFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Store.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int storeID = Integer.parseInt(data[0]);
                    String storeName = data[1];
                    int storeOwnerID = Integer.parseInt(data[2]);
                    String storeAddress = data[3];

                    Store store = new Store(storeID, storeName, storeOwnerID, storeAddress);
                    storeList.add(store);
                } else {
                    System.out.println("Invalid store data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void displayStoreList() {
        System.out.println("Store List:");
        if (storeList.isEmpty()) {
            System.out.println("No Stores available.");
        } else {
            for (Store store : storeList) {
                System.out.println(store.getStoreID()+"-"+store.getStoreName()+"-"+store.getOwnerID()+"-"+store.getAddress());
            }
        }
    }

    public static void updateStore() {
        displayStoreList();
        System.out.println("Enter Store ID :");
        int storeID = Integer.parseInt(scanner.nextLine());

        Store selectedStore = null;

        for (Store store : storeList) {
            if (store.getStoreID() == storeID) {
                selectedStore = store;
                break;
            }
        }

        if (selectedStore != null) {
            System.out.println("Select the property to update:");
            System.out.println("1. Store Name");
            System.out.println("2. Owner Name");
            System.out.println("3. Address");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter new Store Name:");
                    String newStoreName = scanner.nextLine();
                    selectedStore.setStoreName(newStoreName);
                    StoreService.writeStoreToFile();
                    System.out.println("Store Name has been updated.");
                    break;
                case 2:
                    System.out.println("Enter new Owner ID:");
                    int newOwnerID = Integer.parseInt(scanner.nextLine());
                    selectedStore.setOwnerID(newOwnerID);
                    StoreService.writeStoreToFile();
                    System.out.println("Owner Name has been updated.");
                    break;
                case 3:
                    System.out.println("Enter new Address:");
                    String newAddress = scanner.nextLine();
                    selectedStore.setAddress(newAddress);
                    StoreService.writeStoreToFile();
                    System.out.println("Address has been updated.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Store not found.");
        }
    }



    public static void deleteStore() {
        displayStoreList();
        System.out.println("Enter Store ID:");
        int storeID = Integer.parseInt(scanner.nextLine());

        Store selectedStore = null;

        for (Store store : storeList) {
            if (store.getStoreID() == storeID) {
                selectedStore = store;
                break;
            }
        }

        if (selectedStore != null) {
            storeList.remove(selectedStore);
            writeStoreToFile();
            System.out.println("Store has been deleted successfully.");
        } else {
            System.out.println("Store not found.");
        }
    }

    public static void processRentPayment() throws IOException {
        displayStoreList();
        int storeId;
        double storeRent = 500.0;
        boolean backToSellerManageSystem = false;

        while (!backToSellerManageSystem) {
            System.out.println("Enter Store ID (0 to exit):");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.exit(0);
            }

            try {
                storeId = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Store ID. Please try again.");
                continue;
            }

            Store selectedStore = findStoreByStoreId(storeId);

            if (selectedStore == null) {
                System.out.println("Invalid Store ID. Please try again.");
                continue;
            }

            System.out.println("Selected Store: " + selectedStore.getStoreName());

            while (true) {
                System.out.println("1. Pay Store Rent");
                System.out.println("2. Back to Store Selection");
                System.out.println("3. Back");

                input = scanner.nextLine();

                if (input.isEmpty()) {
                    System.out.println("Invalid choice.");
                    continue;
                }

                int choice;

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Enter the payment amount:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();

                        if (amount < storeRent) {
                            System.out.println("Insufficient payment amount.");
                        } else {
                            double change = amount - storeRent;
                            System.out.println("Change amount: " + change);
                            System.out.println("Payment successful. Thank you!");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        backToSellerManageSystem = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }

                if (choice == 2 || backToSellerManageSystem) {
                    break;
                }
            }
        }

        System.out.println("Enter seller ID :");
        int sellerID = Integer.parseInt(scanner.nextLine());
        sellerManageSystem(sellerID);
    }

    public static Store findStoreByStoreId(int storeId) {
        for (Store store : storeList) {
            if (store.getStoreID()== storeId) {
                return store;
            }
        }
        return null;
    }
}

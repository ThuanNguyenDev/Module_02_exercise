package Service;
import Entities.Customer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements Serializable {
    static Scanner scanner = new Scanner(System.in);
    static List<Customer> customerList = new ArrayList<>();
    public static void Register() {
        displayCustomerList();

        boolean isRegistered = false;
        do {
            try {
                System.out.print("Enter customer ID: ");
                int customerID = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter customer password: ");
                String customerPassword = scanner.nextLine();
                System.out.print("Enter customer name: ");
                String customerName = scanner.nextLine();
                System.out.println("Enter customer email: ");
                String customerEmail = scanner.nextLine();
                System.out.println("Enter customer address: ");
                String customerAddress = scanner.nextLine();
                System.out.println("Enter customer Phone number: ");
                String customerPhoneNumber = scanner.nextLine();
                System.out.println("Enter Customer Cart ID:");
                int customerCartID = Integer.parseInt(scanner.nextLine());

                Customer newCustomer = new Customer(customerID, customerPassword, customerName, customerEmail, customerAddress, customerPhoneNumber,customerCartID);

                for (Customer customer : customerList) {
                    if (customer.getCustomerID() == customerID) {
                        throw new Exception("Customer ID already exists");
                    }
                }

                customerList.add(newCustomer);
                writeCustomerToFile();
                System.out.println("Customer successfully registered");
                isRegistered = true;
                customerLoginAndManageSystem();
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
            }
        } while (!isRegistered);
    }


    public static void writeCustomerToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Customer.csv"))) {
            for (Customer customer : customerList) {
                String customerData = customer.getCustomerID() + "," +
                        customer.getCustomerPassword() + "," +
                        customer.getCustomerName() + "," +
                        customer.getCustomerEmail() + "," +
                        customer.getCustomerAddress() + "," +
                        customer.getCustomerPhoneNumber();
                writer.write(customerData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing customer data: " + e.getMessage());
        }
    }

    public static void customerLoginAndManageSystem() throws Exception {
        displayCustomerList();

        System.out.print("Enter customer ID: ");
        int customerID = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter customer password: ");
        String customerPassword = scanner.nextLine();

        Customer loggedCustomer = null;

        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID && customer.getCustomerPassword().equals(customerPassword)) {
                loggedCustomer = customer;
                break;
            }
        }

        if (loggedCustomer !=null) {
            System.out.println("Logged in successfully!");
            customerManageSystem(customerID);
        } else {
            System.out.println("User ID and password do not match/exist");
            main(null);
        }
    }

    public static void customerManageSystem(int customerID) throws Exception {
        Customer selectedCustomer = getCustomerByID(customerID);

        if (selectedCustomer != null) {
            while (true) {
                System.out.println("Welcome " + selectedCustomer.getCustomerName() + " to our shopping system!");
                System.out.println("Please choose one of the following options:");
                System.out.println("1. Customer Account Management");
                System.out.println("2. View Category List");
                System.out.println("3. View products of a Category");
                System.out.println("4. Search Product by Price");
                System.out.println("5. Search Product by Name");
                System.out.println("6. Add product to cart");
                System.out.println("7. Create Cart");
                System.out.println("8. Remove product from cart");
                System.out.println("9. Change Product Quantity");
                System.out.println("10. View Cart");
                System.out.println("11. Update delivery address, Order and confirm payment method");
                System.out.println("12. Check Order Detail");
                System.out.println("13. Back");

                try {
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            customerAccountManagement();
                            break;
                        case 2:
                            CategoryService.displayCategories();
                            break;
                        case 3:
                            ProductService.displayProductsByCategoryID();
                            break;
                        case 4:
                            ProductService.searchProductByPrice();
                            break;
                        case 5:
                            ProductService.searchProductByName();
                            break;
                        case 6:
                            CartLineService.addProductToCart();
                            break;
                        case 7:
                            CartService.createCart();
                            break;
                        case 8:
                            CartService.removeProductFromCart();
                            break;
                        case 9:
                            CartService.changeProductQuantity();
                            break;
                        case 10:
                            CartService.viewCart();
                            break;
                        case 11:
                            OrderService.CheckOut();
                            break;
                        case 12:
                            OrderService.checkOrderDetail();
                            break;
                        case 13:
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 13.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } else {
            System.out.println("Customer not found.");
        }
    }


    public static Customer getCustomerByID(int customerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID) {
                return customer;
            }
        }
        return null;
    }



    public static void customerAccountManagement() {
        displayCustomerList();

        System.out.println("Enter Customer ID:");
        int customerID = Integer.parseInt(scanner.nextLine());

        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID) {
                System.out.println(customer);
                System.out.println("Account management information as the following : ");
                System.out.println("1. Change Password");
                System.out.println("2. Change Name");
                System.out.println("3. Change Email");
                System.out.println("4. Change Address");
                System.out.println("5. Change Phone Number");
                System.out.println("6. Back");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 : {
                        System.out.println("Enter your old password: ");
                        String oldPass = scanner.nextLine();
                        if (customer.getCustomerPassword().equals(oldPass)) {
                            System.out.println("Enter your new password: ");
                            String newPass = scanner.nextLine();
                            customer.setCustomerPassword(newPass);
                            System.out.println("Password changed successfully !");
                            writeCustomerToFile();
                        } else {
                            System.out.println("Invalid old password");
                        }
                        break;
                    }
                    case 2 : {
                        System.out.println("Enter your new name: ");
                        String newName = scanner.nextLine();
                        customer.setCustomerName(newName);
                        System.out.println("Name changed successfully !");
                        writeCustomerToFile();
                        break;
                    }
                    case 3 : {
                        System.out.println("Enter your new email: ");
                        String newEmail = scanner.nextLine();
                        customer.setCustomerEmail(newEmail);
                        System.out.println("Email changed successfully !");
                        writeCustomerToFile();
                        break;
                    }
                    case 4 : {
                        System.out.println("Enter your new address: ");
                        String newAddress = scanner.nextLine();
                        customer.setCustomerAddress(newAddress);
                        System.out.println("Address changed successfully !");
                        writeCustomerToFile();
                        break;
                    }
                    case 5 : {
                        System.out.println("Enter your new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        customer.setCustomerPhoneNumber(newPhoneNumber);
                        System.out.println("Phone Number changed successfully !");
                        writeCustomerToFile();
                        break;
                    }
                    case 6 :
                        customerAccountManagement();
                        break;
                    default :
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }

                customerAccountManagement();
                return;
            }
        }

        System.out.println("No such Customer");
    }


    public static void readCustomerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Customer.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] customerData = line.split(",");
                if (customerData.length == 7) {
                    int customerID = Integer.parseInt(customerData[0]);
                    String customerPassword = customerData[1];
                    String customerName = customerData[2];
                    String customerEmail = customerData[3];
                    String customerAddress = customerData[4];
                    String customerPhoneNumber = customerData[5];
                    int customerCartID = Integer.parseInt(customerData[6]);

                    Customer customer = new Customer(customerID, customerPassword, customerName, customerEmail, customerAddress, customerPhoneNumber,customerCartID);
                    customerList.add(customer);
                } else {
                    System.out.println("Invalid customer data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading customer data: " + e.getMessage());
        }
    }


    public static void displayCustomerList() {
        System.out.println("Customer List : ");
        if (customerList.isEmpty()) {
            System.out.println("No Customer available.");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer.getCustomerID() + "-" + customer.getCustomerName() + "-" + customer.getCustomerEmail() + "-" + customer.getCustomerAddress() + "-" + customer.getCustomerPhoneNumber());
            }
        }
    }


    public static Customer findCustomer() {
        displayCustomerList();

        System.out.println("Enter customer ID: ");
        int customerID = Integer.parseInt(scanner.nextLine());

        Customer foundCustomer = null;

        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID) {
                foundCustomer = customer;
                break;
            }
        }

        if (foundCustomer != null) {
            return foundCustomer;
        } else {
            System.out.println("Customer not found.");
            return null;
        }
    }

    public static void main(String[] args) {
        try {


            int choice;

            do {
                System.out.println("We have these options as the following:");
                System.out.println("1. Register");
                System.out.println("2. Log In");
                System.out.println("3. Exit");

                choice = Integer.parseInt(scanner.nextLine());

                try {
                    switch (choice) {
                        case 1:
                            Register();
                            break;
                        case 2:
                            customerLoginAndManageSystem();
                            break;
                        case 3:
                            System.out.println("Exiting.....");
                            return;
                        default:
                            System.out.println("Invalid choice. Please input again!");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                    e.printStackTrace();
                }
            } while (true);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
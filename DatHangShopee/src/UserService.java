import Service.*;

import java.util.Scanner;

public class UserService {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException {
        try {

            AdminService.readAdminFromFile();
            CustomerService.readCustomerFromFile();
            SellerService.readSellerFromFile();
            OwnerService.readOwnerFromFile();
            StoreService.readStoreFromFile();
            CategoryService.readCategoryFromFile();
            ProductService.readProductFromFile();
            CartLineService.readCartLineFromFile();
            CartService.readCartFromFile();
            OrderService.readOrderFromFile();

            int choice;

            do {
                System.out.println("----ONLINE SHOPPING SYSTEM----");
                System.out.println("Choose your role:");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.println("3. Owner");
                System.out.println("4. Seller");
                System.out.println("5. Exit");

                choice = validateInput(scanner.nextLine(), 1, 5);

                switch (choice) {
                    case 1:
                        AdminService.main(null);
                        break;
                    case 2:
                        CustomerService.main(null);
                        break;
                    case 3:
                        OwnerService.main(null);
                        break;
                    case 4:
                        SellerService.main(null);
                        break;
                    case 5:
                        System.out.println("Exiting from program...");
                        System.out.println("Thank you for using this shopping system!");
                        return;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static int validateInput(String input, int min, int max) {
        try {
            int choice = Integer.parseInt(input);
            if (choice < min || choice > max) {
                throw new IllegalArgumentException("Invalid choice");
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return validateInput(scanner.nextLine(), min, max);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice. Please enter a valid option.");
            return validateInput(scanner.nextLine(), min, max);
        }
    }
}


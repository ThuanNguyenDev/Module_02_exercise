package Service;
import Entities.CartLine;
import Entities.Customer;
import Entities.Product;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import static Service.CustomerService.customerList;
import static Service.ProductService.productList;
import static java.lang.Integer.parseInt;

public class CartLineService {
    static Scanner scanner = new Scanner(System.in);
    static List<CartLine> cart = new ArrayList<>();
    public static void addProductToCart() {
        System.out.print("Enter Cart ID: ");
        int cartID = parseInt(scanner.nextLine());

        Customer existingCustomer = null;
        for (Customer customer : customerList) {
            if (customer.getCartID() == cartID) {
                existingCustomer = customer;
                break;
            }
        }

        if (existingCustomer == null) {
            System.out.println("Customer does not have a cart. Please create a cart first.");
            return;
        }

        System.out.println("There are all products we have as the following , please view and pick the product you are interested in :");
        ProductService.viewAllProducts();

        System.out.print("Enter Product ID: ");
        int productID = parseInt(scanner.nextLine());

        Product addProduct = null;
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                addProduct = product;
                break;
            }
        }

        if (addProduct != null) {
            System.out.println("Enter number of Sizes:");
            int numSizes = parseInt(scanner.nextLine());
            List<String> sizes = new ArrayList<>();

            for (int i = 0; i < numSizes; i++) {
                System.out.println("Enter Size " + (i + 1) + ":");
                String size = scanner.nextLine();
                sizes.add(size);
            }

            System.out.println("Enter number of Colors:");
            int numColors = parseInt(scanner.nextLine());
            List<String> colors = new ArrayList<>();

            for (int i = 0; i < numColors; i++) {
                System.out.println("Enter Color " + (i + 1) + ":");
                String color = scanner.nextLine();
                colors.add(color);
            }

            System.out.println("Enter Quantity:");
            int quantity = parseInt(scanner.nextLine());

            double subtotalPrice = addProduct.getProductPrice() * quantity;

            CartLine cartLine = new CartLine(addProduct, sizes, colors, quantity, subtotalPrice);
            cart.add(cartLine);
            writeCartLineToFile();
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void writeCartLineToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("CartLine.csv"))) {
            for (CartLine cartLine : cart) {
                StringBuilder line = new StringBuilder();
                Product product = cartLine.getProduct();
                line.append(product.getProductID()).append(",")
                        .append(product.getCategoryID()).append(",")
                        .append(product.getProductName()).append(",")
                        .append(product.getProductPrice()).append(",");

                line.append(String.join(";", cartLine.getSizes())).append(",");
                line.append(String.join(";", cartLine.getColors())).append(",");
                line.append(cartLine.getOrderProductQuantity()).append(",")
                        .append(cartLine.getSubtotalPrice()).append("\n");

                writer.write(line.toString());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the CartLine data to the file.");
            e.printStackTrace();
        }
    }

    public static void readCartLineFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("CartLine.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 8) {
                    System.out.println("Invalid cart line data: " + line);
                    continue;
                }
                int productId = Integer.parseInt(data[0]);
                int categoryId = Integer.parseInt(data[1]);
                String productName = data[2];
                double productPrice = Double.parseDouble(data[3]);

                List<String> sizes = new ArrayList<>();
                int sizeStartIndex = 4;
                int sizeEndIndex = sizeStartIndex + (data.length - 8) / 2;
                for (int i = sizeStartIndex; i <= sizeEndIndex; i++) {
                    sizes.add(data[i]);
                }

                List<String> colors = new ArrayList<>();
                int colorStartIndex = sizeEndIndex + 1;
                int colorEndIndex = data.length - 3;
                for (int i = colorStartIndex; i <= colorEndIndex; i++) {
                    colors.add(data[i]);
                }

                int quantity = Integer.parseInt(data[colorEndIndex + 1]);
                double subtotalPrice = Double.parseDouble(data[colorEndIndex + 2]);

                Product product = new Product(productId, categoryId, productName, productPrice);
                CartLine cartLine = new CartLine(product, sizes, colors, quantity, subtotalPrice);
                cart.add(cartLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("CartLine file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CartLine data from the file: " + e.getMessage());
        }
    }

}

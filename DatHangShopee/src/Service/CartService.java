package Service;
import Entities.Cart;
import Entities.CartLine;
import Entities.Customer;
import Entities.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static Service.CartLineService.*;
import static Service.CustomerService.findCustomer;
public class CartService {
    static Scanner scanner = new Scanner(System.in);
    static List<Cart> cartList = new ArrayList<>();

    public static void createCart() {
        Customer orderCustomer = findCustomer();

        if (orderCustomer == null) {
            System.out.println("Customer not found. Cannot create cart.");
            return;
        }

        int cartID = orderCustomer.getCartID();
        if (cartID == 0) {
            System.out.println("Customer does not have a cart. Cannot create cart.");
            return;
        }

        List<CartLine> customerCart = new ArrayList<>(cart);
        Cart newCart = new Cart(cartID, orderCustomer,customerCart );
        cartList.add(newCart);
        writeCartToFile();
        System.out.println("Cart created successfully.");
    }


    public static void clearCart() {
        System.out.println("Enter the cartID to clear: ");
        int cartID = Integer.parseInt(scanner.nextLine());

        List<Cart> cartsToRemove = new ArrayList<>();

        for (Cart cart : cartList) {
            if (cart.getCartID() == cartID) {
                cartsToRemove.add(cart);
            }
        }

        cartList.removeAll(cartsToRemove);
        CartService.writeCartToFile();

        System.out.println("Cart with cartID " + cartID + " have been cleared.");
    }

    public static void viewCart() throws Exception {
        System.out.println("Enter Cart ID:");
        int cartID = Integer.parseInt(scanner.nextLine());

        Cart cartToView = null;
        for (Cart cart : cartList) {
            if (cart.getCartID() == cartID) {
                cartToView = cart;
                break;
            }
        }

        if (cartToView == null) {
            System.out.println("Invalid Cart ID. Please try again.");
            return;
        }

        System.out.println("-----BILL-----");
        for (CartLine cartLine : cart) {
            System.out.println("ID Product: " + cartLine.getProduct().getProductID());
            System.out.println("Name Product: " + cartLine.getProduct().getProductName());
            System.out.println("Size: " + cartLine.getSizes() + " - Color: " + cartLine.getColors());
            System.out.println("Ordered Quantity: " + cartLine.getOrderProductQuantity());
            System.out.println("Subtotal Price: " + cartLine.getSubtotalPrice());
        }

        System.out.println("Total Amount = " + totalPrice());
        System.out.println("Do you want to continue to payment or remove items in cart?");
        System.out.println("1. Make Payment");
        System.out.println("2. Update Quantity");
        System.out.println("3. Edit Cart");
        System.out.println("4. Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                OrderService.CheckOut();
                break;
            case 2:
                changeProductQuantity();
                break;
            case 3:
                removeProductFromCart();
                break;
            case 4:
                System.out.println("Enter Customer ID:");
                int customerID = Integer.parseInt(scanner.nextLine());
                CustomerService.customerManageSystem(customerID);
                break;
        }
    }


    public static void changeProductQuantity() throws Exception {
        System.out.println("Enter Product ID:");
        int productID = Integer.parseInt(scanner.nextLine());
        CartLine selectedCartLine = null;

        for (CartLine cartLine : cart) {
            if (cartLine.getProduct().getProductID() == productID) {
                selectedCartLine = cartLine;
                break;
            }
        }

        if (selectedCartLine != null) {
            System.out.println("Current quantity: " + selectedCartLine.getOrderProductQuantity());
            System.out.println("Enter new quantity to update:");
            int newQuantity = Integer.parseInt(scanner.nextLine());
            double productPrice = selectedCartLine.getProduct().getProductPrice();
            double newSubtotalPrice = productPrice * newQuantity;

            selectedCartLine.setOrderProductQuantity(newQuantity);
            selectedCartLine.setSubtotalPrice(newSubtotalPrice);

            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Product not found in your cart.");
        }

        CartService.viewCart();
    }
    public static void removeProductFromCart() throws Exception {
        System.out.println("Enter Product ID to remove :");
        int productID = Integer.parseInt(scanner.nextLine());
        boolean productFound = false;

        for (CartLine cartLine : cart) {
            if (cartLine.getProduct().getProductID() == productID) {
                cart.remove(cartLine);
                productFound = true;
                break;
            }
        }

        if (productFound) {
            System.out.println("Product removed from cart successfully.");
        } else {
            System.out.println("Product not found in the cart.");
        }
        CartService.viewCart();

    }

    public static double totalPrice() {
        double totalPrice = 0;
        for (CartLine cartLine : cart) {
            totalPrice += cartLine.getSubtotalPrice();
        }
        return totalPrice;
    }
    public static void writeCartToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Cart.csv"))) {
            for (Cart cart : cartList) {
                String line = cart.getCartID() + "," +
                        formatCustomerToString(cart.getCustomer()) + "," +
                        convertCartToString() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing cart data: " + e.getMessage());
        }
    }

    public static void readCartFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Cart.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cartData = line.split(",");
                if (cartData.length != 3) {
                    continue;
                }
                int cartID = isInteger(cartData[0]) ? Integer.parseInt(cartData[0]) : 0;
                Customer customer = parseCustomerFromString(cartData[1]);
                List<CartLine> customerCart = parseCartFromString(cartData[2]);

                Cart cart = new Cart(cartID, customer, customerCart);
                cartList.add(cart);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cart file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading cart data: " + e.getMessage());
        }
    }

    private static String formatCustomerToString(Customer customer) {
        return customer.getCustomerID() + "," +
                customer.getCustomerName() + "," +
                customer.getCustomerPhoneNumber() + "," +
                customer.getCartID();
    }

    private static StringBuilder convertCartToString() {
        StringBuilder sb = new StringBuilder();
        for (CartLine cartLine : cart) {
           return sb.append(formatCartLineToString(cartLine)).append(",");
        }
        return sb;
    }

    private static String formatCartLineToString(CartLine cartLine) {
        return  cartLine.getProduct().getProductID() + "," +
                cartLine.getProduct().getProductName() + "," +
                formatListToString(cartLine.getSizes()) + "," +
                formatListToString(cartLine.getColors()) + "," +
                cartLine.getOrderProductQuantity() + "," +
                cartLine.getSubtotalPrice();
    }

    private static List<CartLine> parseCartFromString(String cartString) {
        List<CartLine> cart = new ArrayList<>();
        String[] cartItems = cartString.split(",");

        for (String item : cartItems) {
            CartLine cartLine = parseCartLineFromString(item);
            if (cartLine != null) {
                cart.add(cartLine);
            }
        }

        return cart;
    }

    private static CartLine parseCartLineFromString(String cartLineString) {
        String[] cartLineData = cartLineString.split(":");
        if (cartLineData.length != 6) {
            System.out.println("Invalid cart line data: " + cartLineString);
            return null;
        }

        int productID = isInteger(cartLineData[0]) ? Integer.parseInt(cartLineData[0]) : 0;
        String productName = cartLineData[1];
        List<String> sizes = parseListFromString(cartLineData[2]);
        List<String> colors = parseListFromString(cartLineData[3]);
        int orderProductQuantity = isInteger(cartLineData[4]) ? Integer.parseInt(cartLineData[4]) : 0;
        double subtotalPrice = Double.parseDouble(cartLineData[5]);

        Product product = new Product(productID, 0, productName, 0);
        return new CartLine(product, sizes, colors, orderProductQuantity, subtotalPrice);
    }

    private static List<String> parseListFromString(String listString) {
        String[] items = listString.split(",");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, items);
        return list;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String formatListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static Customer parseCustomerFromString(String customerData) {
        String[] customerInfo = customerData.split(":");
        if (customerInfo.length != 7) {
            System.out.println("Invalid customer data: " + customerData);
            return null;
        }
        int customerID = isInteger(customerInfo[0]) ? Integer.parseInt(customerInfo[0]) : 0;
        String customerName = customerInfo[2];
        String customerPhoneNumber = customerInfo[3];
        int cartID = isInteger(customerInfo[4]) ? Integer.parseInt(customerInfo[4]) : 0;

        return new Customer(customerID, "", customerName, customerPhoneNumber, "", "", cartID);
    }
}

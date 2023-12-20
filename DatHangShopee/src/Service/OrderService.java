package Service;
import Entities.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import static Service.CartLineService.cart;
import static Service.CartService.*;
import static Service.CustomerService.findCustomer;
import static java.lang.Integer.parseInt;

public class OrderService implements Serializable {
    private static String houseNum;
    private static String state;
    private static String district;
    private static String phoneNumber;
    private static String postCode;
    static List<Order> orderList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void placeOrder() {
        int newOrderID = orderList.size() + 1;
        LocalDateTime orderDateTime = LocalDateTime.now();
        Customer orderCustomer = findCustomer();

        if (orderCustomer != null) {
            Cart customerCart = null;
            for (Cart cart : cartList) {
                if (cart.getCartID() == orderCustomer.getCartID()) {
                    customerCart = cart;
                    break;
                }
            }

            if (customerCart != null) {
                double totalPrice = totalPrice();
                String statusOrder = "Pending";
                Order newOrder = new Order(newOrderID, orderDateTime, orderCustomer, customerCart.getCustomerCart(), totalPrice, statusOrder);
                orderList.add(newOrder);
                writeOrderToFile();
                System.out.println("Order placed successfully. Order ID: " + newOrderID);
                System.out.println("Order Details:");
                System.out.println("Order ID: " + newOrder.getOrderID());
                System.out.println("Order Date and Time: " + newOrder.getOrderDateTime());
                System.out.println("Customer: " + newOrder.getCustomer().getCustomerName());
                System.out.println("Total Price: " + newOrder.getTotalPrice());
                System.out.println("Status: " + newOrder.getStatusOrder());
                System.out.println("-------------------------");
            } else {
                System.out.println("Failed to place order. Cart not found.");
            }
        } else {
            System.out.println("Failed to place order. Customer not found.");
        }
    }

    public static void checkOrderDetail() {
        displayOrderList();

        System.out.println("Enter Order ID: ");
        int orderID = 0;
        boolean validInput = false;

        do {
            try {
                orderID = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Order ID. Please enter a valid number.");
                System.out.println("Enter Order ID again: ");
            }
        } while (!validInput);

        Order foundOrder = null;

        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                foundOrder = order;
                break;
            }
        }

        if (foundOrder != null) {
            System.out.println("Order Details for Order ID: " + foundOrder.getOrderID());
            System.out.println("Order Date and Time: " + foundOrder.getOrderDateTime());
            System.out.println("Customer: " + foundOrder.getCustomer().getCustomerName());
            System.out.println();

            System.out.println("Cart Details:");
            List<CartLine> cart = foundOrder.getCart();
            for (CartLine cartLine : cart) {
                System.out.println("Product ID: " + cartLine.getProduct().getProductID());
                System.out.println("Product Name: " + cartLine.getProduct().getProductName());
                System.out.println("Sizes: " + String.join(", ", cartLine.getSizes()));
                System.out.println("Colors: " + String.join(", ", cartLine.getColors()));
                System.out.println("Quantity: " + cartLine.getOrderProductQuantity());
                System.out.println("Subtotal Price: " + cartLine.getSubtotalPrice());
                System.out.println();
            }

            System.out.println("Total Price: " + foundOrder.getTotalPrice());
            System.out.println("Status: " + foundOrder.getStatusOrder());

        } else {
            System.out.println("Order not found.");
        }
    }

    public static void acceptOrderRequest() {
        displayOrderList();

        System.out.println("Enter Order ID: ");
        int orderID;
        try {
            orderID = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Order ID. Please enter a valid number.");
            return;
        }

        Order foundOrder = null;

        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                foundOrder = order;
                break;
            }
        }

        if (foundOrder != null) {
            if (foundOrder.getStatusOrder().equals("Pending")) {
                foundOrder.setStatusOrder("Accepted");

                Cart customerCart = getCustomerCart(foundOrder.getCustomer().getCartID());

                if (customerCart != null) {
                    System.out.println("Customer: " + foundOrder.getCustomer().getCustomerName());
                    System.out.println("Cart ID: " + foundOrder.getCustomer().getCartID());
                    System.out.println("Cart Lines: ");
                    for (CartLine cartLine : customerCart.getCustomerCart()) {
                        System.out.println("- Product: " + cartLine.getProduct().getProductName());
                        System.out.println("  Sizes: " + String.join(", ", cartLine.getSizes()));
                        System.out.println("  Colors: " + String.join(", ", cartLine.getColors()));
                        System.out.println("  Quantity: " + cartLine.getOrderProductQuantity());
                        System.out.println("  Subtotal Price: " + cartLine.getSubtotalPrice());
                        System.out.println();
                    }
                } else {
                   //System.out.println("Cart not found for the customer.");
                }

                writeOrderToFile();

                System.out.println("Order " + orderID + " request has been accepted.");
            } else {
                System.out.println("Order " + orderID + " is not in pending state.");
            }
        } else {
            System.out.println("Order not found.");
        }
    }

    private static Cart getCustomerCart(int cartID) {
        for (Cart cart : cartList) {
            if (cart.getCartID() == cartID) {
                return cart;
            }
        }
        return null;
    }


    public static void displayOrderList() {
        if (orderList.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            System.out.println("Order List:");
            for (Order order : orderList) {
                System.out.println(" Order ID: " + order.getOrderID());
                System.out.println(" Order Date/Time: " + order.getOrderDateTime());
                System.out.println(" Customer: " + order.getCustomer().getCustomerName());
                System.out.println(" Total Price: " + order.getTotalPrice());
                System.out.println(" Status: " + order.getStatusOrder());
                System.out.println("------------------------------");
            }
        }
    }


    public static void viewOrderHistory() {
        System.out.println("Enter Order ID: ");
        int orderID = Integer.parseInt(scanner.nextLine());

        Order foundOrder = null;

        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                foundOrder = order;
                break;
            }
        }

        if (foundOrder != null) {
            System.out.println("Order History for Order ID: " + foundOrder.getOrderID());
            System.out.println(" Order Date: " + foundOrder.getOrderDateTime());
            System.out.println(" Total Price: " + foundOrder.getTotalPrice());
            System.out.println(" Status: " + foundOrder.getStatusOrder());
            System.out.println("-------------------------");
        } else {
            System.out.println("Order not found.");
        }
    }




    public static void detailsOfBuyer()  {
        System.out.println(" The delivery address details for your order: ");
        System.out.println(" Enter House number: ");
        houseNum = scanner.nextLine();
        System.out.println(" Enter State:");
        state = scanner.nextLine();
        System.out.println(" Enter District:");
        district = scanner.nextLine();
        System.out.println(" Enter Phone number: ");
        phoneNumber = scanner.nextLine();
        System.out.println(" Enter Post code: ");
        postCode = scanner.nextLine();
    }

    public static void CheckOut() throws Exception {
        boolean isValidChoice = false;
        int choice = 0;

        do {
            try {
                System.out.println("--Mode of Payment--");
                System.out.println(" Choose the option:");
                System.out.println("1. Debit /Credit /ATM cards");
                System.out.println("2. Cash on Delivery (COD)");
                System.out.println("3. Back");

                choice = parseInt(scanner.nextLine());

                isValidChoice = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (!isValidChoice);

        switch (choice) {
            case 1:
                try {
                    detailsOfBuyer();
                    System.out.print("Enter the name of the card holder:");
                    String cardName = scanner.next();
                    System.out.print("Enter the card number:");
                    long cardNo = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter CVV (the three digit number printed on the back of the card):");
                    int cvv = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the expiry DD/MM/YYYY");
                    int expDate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Verify you delivery details");
                    System.out.println("House Number : " + houseNum);
                    System.out.println("Province : " + state);
                    System.out.println("District : " + district);
                    System.out.println("Cellphone : " + phoneNumber);
                    System.out.println("Post code : " + postCode);
                    System.out.println("Verify your card's detail: ");
                    System.out.println("Your card's name : " + cardName);
                    System.out.println("Your card's number : " + cardNo);
                    System.out.println("Your three last numbers of your card : " + cvv);
                    System.out.println("Your card's expired date : " + expDate);
                    System.out.println("1. To continue payment");
                    System.out.println("2. To stop payment");

                    int choiceCard = scanner.nextInt();

                    if (choiceCard == 1) {
                        placeOrder();
                        cart.clear();
                        CartLineService.writeCartLineToFile();
                        CartService.clearCart();
                        System.out.println("-----------Your order is success----------");
                        System.out.println("Exiting from program...");
                        System.out.println("Thanks for using this shopping system!");
                        System.exit(0);
                    } else {
                        System.out.println("-----------Your order is cancelled-----------");
                        CartService.viewCart();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    CartService.viewCart();
                }
                break;

            case 2:
                try {
                    detailsOfBuyer();
                    System.out.println("Verify you delivery details ");
                    System.out.println("House Number : " + houseNum);
                    System.out.println("Province : " + state);
                    System.out.println("District : " + district);
                    System.out.println("Cellphone : " + phoneNumber);
                    System.out.println("Post code : " + postCode);
                    System.out.println("1. To continue the COD ");
                    System.out.println("2. To stop the COD ");

                    int choiceCOD = scanner.nextInt();
                    if (choiceCOD == 1) {
                        placeOrder();
                        cart.clear();
                        CartLineService.writeCartLineToFile();
                        CartService.clearCart();
                        System.out.println("-----------Your order is success----------");
                    } else {
                        System.out.println("-----------Your order is cancelled-----------");
                        CartService.viewCart();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    CartService.viewCart();
                }
                break;

            case 3:
                CartService.viewCart();
                break;

            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }


    public static void writeOrderToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Order.csv", true))) {
            Order order = orderList.get(orderList.size() - 1);

            StringBuilder line = new StringBuilder();
            line.append(order.getOrderID()).append(",");
            line.append(order.getOrderDateTime()).append(",");
            line.append(order.getCustomer().getCustomerID()).append(",");
            line.append(order.getCustomer().getCustomerName()).append(",");
            line.append(order.getCustomer().getCustomerPhoneNumber()).append(",");
            line.append(order.getCustomer().getCartID()).append(",");
            line.append(convertCartLinesToString()).append(",");
            line.append(order.getTotalPrice()).append(",");
            line.append(order.getStatusOrder());

            writer.write(line.toString());
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred while writing order data: " + e.getMessage());
        }
    }

    private static String convertCartLinesToString() {
        StringBuilder sb = new StringBuilder();
        for (CartLine cartLine : cart) {
            sb.append(formatCartLineToString(cartLine)).append(";");
        }
        return sb.toString();
    }

    private static String formatCartLineToString(CartLine cartLine) {
        StringBuilder sb = new StringBuilder();
        sb.append(cartLine.getProduct().getProductID()).append(",");
        sb.append(cartLine.getProduct().getProductName()).append(",");
        sb.append(String.join(",", cartLine.getSizes())).append(",");
        sb.append(String.join(",", cartLine.getColors())).append(",");
        sb.append(cartLine.getOrderProductQuantity()).append(",");
        sb.append(cartLine.getSubtotalPrice());
        return sb.toString();
    }


    public static void readOrderFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Order.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] orderData = line.split(",");
                if (orderData.length != 10) {
                    //System.out.println("Invalid order data: " + line);
                    continue;
                }

                int orderID = Integer.parseInt(orderData[0]);
                LocalDateTime orderDateTime = LocalDateTime.parse(orderData[1]);
                int customerID = Integer.parseInt(orderData[2]);
                String customerName = orderData[3];
                String customerPhoneNumber = orderData[4];
                int cartID = Integer.parseInt(orderData[5]);

                List<CartLine> cart = parseCartLinesFromString(orderData[6]);
                double totalPrice = Double.parseDouble(orderData[7]);
                String statusOrder = orderData[8];

                Customer customer = new Customer(customerID, "", customerName, "", "", customerPhoneNumber, cartID);
                Order order = new Order(orderID, orderDateTime, customer, cart, totalPrice, statusOrder);
                orderList.add(order);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Order file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading order data: " + e.getMessage());
        }
    }

    private static List<CartLine> parseCartLinesFromString(String cartString) {
        List<CartLine> cartLines = new ArrayList<>();
        String[] cartLineItems = cartString.split(";");

        for (String cartLineItem : cartLineItems) {
            String[] cartLineData = cartLineItem.split(",");
            if (cartLineData.length != 6) {
                System.out.println("Invalid cart line data: " + cartLineItem);
                continue;
            }

            int productID = Integer.parseInt(cartLineData[0]);
            String productName = cartLineData[1];
            List<String> sizes = Arrays.asList(cartLineData[2].split(","));
            List<String> colors = Arrays.asList(cartLineData[3].split(","));
            int orderProductQuantity = Integer.parseInt(cartLineData[4]);
            double subtotalPrice = Double.parseDouble(cartLineData[5]);

            Product product = new Product(productID,0, productName,0);

            CartLine cartLine = new CartLine(product, sizes, colors, orderProductQuantity, subtotalPrice);
            cartLines.add(cartLine);
        }
        return cartLines;
    }
}
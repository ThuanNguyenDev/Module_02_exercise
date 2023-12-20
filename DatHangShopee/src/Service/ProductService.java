package Service;
import Entities.Category;
import Entities.Product;
import java.io.*;
import java.util.*;
import static Service.CategoryService.categoryList;
public class ProductService  implements Serializable {
    static List<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void addProduct() {
        viewAllProducts();
        boolean productAdded = false;

        do {
            try {
                System.out.println("Please enter data to create a product: ");
                System.out.print("Enter Category ID: ");
                int categoryID = Integer.parseInt(scanner.nextLine());

                boolean categoryExists = false;
                for (Category category : categoryList) {
                    if (category.getCategoryID() == categoryID) {
                        categoryExists = true;
                        break;
                    }
                }

                if (!categoryExists) {
                    System.out.println("Category ID does not exist. Please inform Admin to create a new category.");
                    return;
                }

                System.out.print("Enter Product ID: ");
                int productID = Integer.parseInt(scanner.nextLine());

                boolean productExists = false;
                for (Product product : productList) {
                    if (product.getProductID() == productID && product.getCategoryID() == categoryID) {
                        productExists = true;
                        break;
                    }
                }

                if (productExists) {
                    System.out.println("Product already exists in the selected category.");
                } else {
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter Product Price: ");
                    double productPrice = Double.parseDouble(scanner.nextLine());

                    Product newProduct = new Product(productID, categoryID, productName, productPrice);
                    productList.add(newProduct);
                    writeProductToFile();
                    System.out.println("Product successfully added.");

                    productAdded = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for ID or Price.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!productAdded);
    }



    public static void writeProductToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Product.csv"))) {
            for (Product product : productList) {
                writer.write(product.getProductID() + "," + product.getCategoryID() + "," + product.getProductName() + "," + product.getProductPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing product data: " + e.getMessage());
        }
    }

    public static void searchProductByID() {
        viewAllProducts();
        System.out.println("Enter Product ID:");
        int productID = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                System.out.println("Product found:");
                System.out.println("Product ID: " + product.getProductID());
                System.out.println("Category ID: " + product.getCategoryID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Price: $" + product.getProductPrice());
                return;
            }
        }
        System.out.println("Product with ID " + productID + " not found.");
    }

    public static void searchProductByPrice() {
        viewAllProducts();
        System.out.print("Enter the price: ");
        double targetPrice = scanner.nextDouble();
        scanner.nextLine();

        boolean found = false;

        for (Product product : productList) {
            if (product.getProductPrice() <= targetPrice) {
                System.out.println("Product ID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Price: " + product.getProductPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found with the given price.");
        }
    }

    public static void searchProductByName() {
        viewAllProducts();
        System.out.println("Enter Product Name: ");
        String searchName = scanner.nextLine();

        List<Product> searchResults = new ArrayList<>();

        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(searchName)) {
                searchResults.add(product);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No products found with the given name.");
        } else {
            System.out.println("Products found with the given name:");
            for (Product product : searchResults) {
                System.out.println("Product ID: " + product.getProductID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Price: " + product.getProductPrice());
                System.out.println("---------------------------");
            }
        }
    }

    public static void displayProductsByCategoryID() {
        System.out.println("Enter Category ID:");
        int categoryID = Integer.parseInt(scanner.nextLine());
        System.out.println("Products in Category " + categoryID + ":");
        boolean found = false;
        for (Product product : productList) {
            if (product.getCategoryID() == categoryID) {
                System.out.println(product.getProductID() + ", " + product.getProductName() + "," + product.getProductPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in Category " + categoryID + ".");
        }
    }

    public static void viewAllProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("All Products:");
            for (Product product : productList) {
                System.out.println("Product ID: " + product.getProductID());
                System.out.println("Category ID: " + product.getCategoryID());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Price: " + product.getProductPrice());
                System.out.println("-------------------------");
            }
        }
    }

    public static void updateProduct() {
        viewAllProducts();
        System.out.println("Enter Product ID to be edited :");
        int productID = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getProductID() == productID) {
                System.out.println("Product Found:");
                System.out.println(product);

                System.out.println("1. Change Product Price");
                System.out.println("2. Change Product Name");
                System.out.println("3. Change Product ID");
                System.out.println("4. Change Category ID");
                System.out.println("5. Back");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter Updated Price: ");
                        double updatedPrice = Double.parseDouble(scanner.nextLine());
                        product.setProductPrice(updatedPrice);
                        System.out.println("Product price changed successfully");
                        ProductService.writeProductToFile();
                        break;
                    case 2:
                        System.out.println("Enter Updated Name: ");
                        String updatedName = scanner.nextLine();
                        product.setProductName(updatedName);
                        System.out.println("Product name changed successfully");
                        ProductService.writeProductToFile();
                        break;
                    case 3:
                        System.out.println("Enter Updated Product ID: ");
                        int updatedProductID = Integer.parseInt(scanner.nextLine());
                        product.setProductID(updatedProductID);
                        System.out.println("Product ID changed successfully");
                        ProductService.writeProductToFile();
                        break;
                    case 4:
                        System.out.println("Enter Updated Category ID: ");
                        int updatedCategoryID = Integer.parseInt(scanner.nextLine());
                        product.setCategoryID(updatedCategoryID);
                        System.out.println("Category ID changed successfully");
                        ProductService.writeProductToFile();
                        break;
                    case 5:
                        SellerService.main(null);
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
                SellerService.main(null);
                return;
            }
        }
        System.out.println("No such Product");
    }

    public static void deleteProduct() {
        viewAllProducts();
        System.out.println("Enter Product ID :");
        int productID = Integer.parseInt(scanner.nextLine());

        Product selectedProduct = null;

        for (Product product : productList) {
            if (product.getProductID() == productID) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {
            productList.remove(selectedProduct);
            ProductService.writeProductToFile();
            System.out.println("Product has been deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void readProductFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Product.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int productID = Integer.parseInt(data[0]);
                    int categoryID = Integer.parseInt(data[1]);
                    String productName = data[2];
                    double productPrice = Double.parseDouble(data[3]);

                    Product product = new Product(productID, categoryID, productName, productPrice);
                    productList.add(product);
                } else {
                    System.out.println("Invalid product data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading product data: " + e.getMessage());
        }
    }


}

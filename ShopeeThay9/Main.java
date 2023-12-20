import entity.Cart;
import entity.Category;
import entity.Product;
import service.CartService;
import service.CategoryService;
import service.ProductService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static CategoryService categoryService = new CategoryService();

    private static ProductService productService = new ProductService();

    private static CartService cartService = new CartService();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Category> categoryList = categoryService.getAll();
        System.out.println(categoryList.toString());

        System.out.println("Enter category ID: ");
        Integer categoryId = Integer.valueOf(sc.nextLine());
        if(!categoryService.checkIdIsExisted(categoryId)){
            //System.out.println("invalid category id");
            throw new IllegalArgumentException("Invalid category id");
        }
        List<Product> productList = productService.getProductListByCategoryId(categoryId);
        System.out.println(productList);

        System.out.println("Enter Product ID that yoy want to buye: ");
        Integer productId = Integer.valueOf(sc.nextLine());
        System.out.println("Enter Quantity of products that you want to order: ");
        Integer quantity = Integer.valueOf(sc.nextLine());
        Cart cart = cartService.addToCart(2, productId, quantity);
        System.out.println(cart);
    }
}
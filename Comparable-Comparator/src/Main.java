import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("iPhone", 1000));
        productList.add(new Product("Samsung", 800));
        productList.add(new Product("Google Pixel", 1200));

        // Sắp xếp danh sách sản phẩm theo giá sử dụng Comparable
        Collections.sort(productList);
        System.out.println("Danh sách sản phẩm theo giá:");
        for (Product product : productList) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }

        // Sắp xếp danh sách sản phẩm theo tên sử dụng Comparator
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        System.out.println();
        System.out.println("Danh sách sản phẩm theo tên:");
        for (Product product : productList) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}
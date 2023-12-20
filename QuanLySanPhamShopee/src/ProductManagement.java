
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class ProductManagement {
    static ArrayList<Product> productList;
    public ProductManagement() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    public void updateProduct(int id) {
        Scanner scanner = new Scanner(System.in);
        for (Product product : productList) {
            if (product.getId() == id) {
                System.out.println("Nhập thông tin mới cho sản phẩm:");
                System.out.print("Tên sản phẩm: ");
                String newName = scanner.nextLine();
                System.out.print("Giá sản phẩm: ");
                double newPrice = scanner.nextDouble();

                product.setName(newName);
                product.setPrice(newPrice);

                System.out.println("Sửa thông tin sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có ID " + id);
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getId() == id) {
                productList.remove(i);
                System.out.println("Xoá sản phẩm thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có ID " + id);
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống!");
            return;
        }
        System.out.println("Danh sách sản phẩm:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void searchProduct(String name) {
        boolean found = false;
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Tìm thấy sản phẩm:");
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có tên " + name);
        }
    }

    public void sortProductsByPriceAscending() {
        Comparator<Product> ascendingComparator = new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        };
        productList.sort(ascendingComparator);
        System.out.println("Sắp xếp sản phẩm tăng dần theo giá thành công!");
    }

    public void sortProductsByPriceDescending() {
        Comparator<Product> descendingComparator = new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getPrice(), p1.getPrice());
            }
        };
        productList.sort(descendingComparator);
        System.out.println("Sắp xếp sản phẩm giảm dần theo giá thành công!");
    }

}

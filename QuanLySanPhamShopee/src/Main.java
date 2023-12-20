import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductManagement productManagement = new ProductManagement();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("-------- Quản lý sản phẩm --------");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xoá sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            System.out.println();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----- Thêm sản phẩm -----");
                    System.out.print("Nhập ID sản phẩm: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Product newProduct = new Product(id, name, price);
                    productManagement.addProduct(newProduct);
                    break;

                case 2:
                    System.out.println("----- Sửa thông tin sản phẩm -----");
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    productManagement.updateProduct(updateId);
                    break;

                case 3:
                    System.out.println("----- Xoá sản phẩm -----");
                    System.out.print("Nhập ID sản phẩm cần xoá: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    productManagement.deleteProduct(deleteId);
                    break;

                case 4:
                    System.out.println("----- Danh sách sản phẩm -----");
                    productManagement.displayProducts();
                    break;

                case 5:
                    System.out.println("----- Tìm kiếm sản phẩm theo tên -----");
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String searchName = scanner.nextLine();
                    productManagement.searchProduct(searchName);
                    break;

                case 6:
                    System.out.println("----- Sắp xếp sản phẩm tăng dần theo giá -----");
                    productManagement.sortProductsByPriceAscending();
                    break;

                case 7:
                    System.out.println("----- Sắp xếp sản phẩm giảm dần theo giá -----");
                    productManagement.sortProductsByPriceDescending();
                    break;

                case 0:
                    System.out.println("----- Kết thúc chương trình -----");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

            System.out.println();

        } while (choice != 0);

        scanner.close();
    }
}

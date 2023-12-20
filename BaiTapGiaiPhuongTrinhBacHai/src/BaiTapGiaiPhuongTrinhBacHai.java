import java.util.Scanner;
public class BaiTapGiaiPhuongTrinhBacHai {
    public static void main(String[] args) {
        double a, b, c, x1, x2, delta;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a vào :");
        a = sc.nextDouble();
        System.out.println("Nhập b vào :");
        b = sc.nextDouble();
        System.out.println("Nhập c vào :");
        c = sc.nextDouble();

        delta = Math.pow(b, 2) - 4 * a * c;

        if (a == 0) {
            System.out.println("Nhập dữ liệu sai!");
        } else {
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm ! ");
            } else if (delta == 0) {
                x1 = -b / (2 * a);
                System.out.println("Phương trình có nghiệm kép x1 = x2 " + x1);
            } else {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                System.out.println("Phương trình có nghiệm là : ");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
    }
}
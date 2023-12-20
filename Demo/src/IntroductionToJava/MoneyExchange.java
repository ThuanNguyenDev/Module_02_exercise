package IntroductionToJava;
import java.util.Scanner;
public class MoneyExchange {
    public static void main(String[] args) {
        double VND = 23000;
        double USD;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền vào : ");
        USD = scanner.nextDouble();
        double exchange = USD*23000;
        System.out.println("Giá trị chuyển đổi là " + exchange);
    }
}

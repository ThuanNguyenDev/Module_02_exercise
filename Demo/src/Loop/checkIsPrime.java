package Loop;
import java.util.Scanner;
public class checkIsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số vào : ");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println(number + " is not a Prime");
        } else {
            int i = 2;
            boolean check = true;
            for (i = 2; i < number; i++) {
                if (number % i == 0) {
                    check = false;
                }
            }

            if (check) {
                System.out.println(number + " is a Prime");
            } else {
                System.out.println(number + " is not a Prime");
            }
        }
    }
}
package Demo;
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
int number;
        do {
            number = sc.nextInt();
            switch (number) {
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                default:
                    System.out.println("Erro");
            }

        } while(number != 0);

    }
}

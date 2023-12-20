package Array;
import java.util.Scanner;
public class CheckElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng: ");
        int n = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng: ");
        int[] arr = new int[n];
        for ( int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ :" + i + ":");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Phần tử trong mảng chia hết cho 3 nhưng không chia hết cho 5 là : ");
        show(arr);
    }

    public static void show(int[] arr) {
        for ( int i = 0; i < arr.length ; i++) {
            if(arr[i]%3 == 0 && arr[i]%5 !=0) {
                System.out.println(arr[i] + " ");
            }
        }
    }
}

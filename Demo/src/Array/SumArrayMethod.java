package Array;
import java.util.Scanner;
public class SumArrayMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập độ dài của mảng: ");
        int n = sc.nextInt();

        System.out.println("Nhập phần tử của mảng: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Phần tử thứ " + i + " :");
            arr[i] = sc.nextInt();
        }

        int sum = sumOfArray(arr);
        System.out.println("Độ dài của mảng là: " + sum);
    }

    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}



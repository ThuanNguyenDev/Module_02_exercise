package Array;
import java.util.Scanner;
public class FindMaxInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng: ");
        int n = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Phần tử thứ " + i + " :");
            arr[i] = scanner.nextInt();
        }

        int maxElement = MaxValue(arr);
        System.out.println("Phần tử lớn nhất trong mảng là " + maxElement);
    }

    public static int MaxValue ( int[] arr1) {
        int max = arr1[0];
        for ( int i = 0 ; i < arr1.length;i++) {
            if ( arr1[i] > max) {
                max = arr1[i];
            }
        }
        return max;
    }
}

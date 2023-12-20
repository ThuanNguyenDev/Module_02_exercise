package Array;
import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng : ");
        int n = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng : ");
        int[] arr = new int[n];
        for ( int i = 0;i <n;i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng trước khi đảo ngược: " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("Mảng sau khi đảo ngược: " + Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

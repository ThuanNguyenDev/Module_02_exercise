package Array;
import java.util.Scanner;
import java.util.Arrays;
public class ReverseArray2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng : ");
        int n = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng: ");
        int[] arr = new int[n];
        for ( int i = 0; i <n;i++) {
            System.out.println("Nhập phần tử thứ " + i + ":");
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        int[] reversedArr = reverseArray(arr);
        System.out.println("Mảng sau khi đảo ngược: " + Arrays.toString(reversedArr));
    }

    public static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] reversedArr = new int[n];
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            reversedArr[j] = arr[i];
        }
        return reversedArr;
    }
}

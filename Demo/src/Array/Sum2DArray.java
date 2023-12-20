package Array;
import java.util.Scanner;
public class Sum2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập số hàng của mảng: ");
        int n = sc.nextInt();

        System.out.println("Nhập số cột của mảng: ");
        int m = sc.nextInt();

        System.out.println("Nhập các phần tử của mảng: ");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Phần tử thứ " + i+j + " :");
                arr[i][j] = sc.nextInt();
            }
        }

        int sum = sum2DArray(arr);
        System.out.println("Tổng các phần tử trong mảng: " + sum);
    }

    public static int sum2DArray(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}

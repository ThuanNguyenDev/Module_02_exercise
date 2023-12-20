package Array;
import java.util.Scanner;
public class MaxElementIn2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số hàng (n): ");
        int n = scanner.nextInt();
        System.out.println("Nhập số cột (m): ");
        int m = scanner.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Nhập phần tử thứ " + i  + j + ": ");
                arr[i][j] = scanner.nextInt();
            }
        }

        int maxElement = findMaxElement(arr);
        System.out.println("Phần tử lớn nhất trong mảng hai chiều là: " + maxElement);
    }

    public static int findMaxElement(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        return max;
    }
}

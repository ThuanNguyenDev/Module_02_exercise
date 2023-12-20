package Array;
import java.util.Scanner;
public class MainDiagonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số dòng : ");
        int n = scanner.nextInt();

        System.out.println("Nhập số cột : ");
        int m = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng :");
        int[][] arr = new int[n][m];
        for ( int i = 0; i < n ; i++) {
            for ( int j = 0; j < m ; j++) {
                System.out.println("Nhập phần tử thứ " + i + j + ":");
                arr[i][j] = scanner.nextInt();
            }
        }

        int diagonalSum = calculateMainDiagonalSum(arr);
        System.out.println("Tổng các số ở đường chéo chính của ma trận là: " + diagonalSum);
    }
    public static int calculateMainDiagonalSum(int[][] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }

        return sum;
    }


}

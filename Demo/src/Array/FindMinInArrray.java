package Array;
import java.util.Scanner;
public class FindMinInArrray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng: ");
        int n = scanner.nextInt();

        System.out.println("Nhập phần tử của mảng: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Phần tử thứ " + i + " :");
            arr[i] = scanner.nextInt();
        }

        int index = minValue(arr);
        System.out.println("Phần tử nhỏ nhất của mảng là" + arr[index] + " ở vị trí " + index + " trong mảng ");
    }
    public static int minValue(int[] arr) {
        int min = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}

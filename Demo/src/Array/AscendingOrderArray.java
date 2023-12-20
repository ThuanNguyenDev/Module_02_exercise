package Array;
import java.util.Scanner;
public class AscendingOrderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng: ");
        int n = sc.nextInt();

        System.out.println("Nhập các phần tử của mảng: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Mảng sau khi sắp xếp: ");

        int[] newArr = ascendingChangeArray(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
    public static int[] ascendingChangeArray ( int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

package Array;
import java.util.Scanner;
public class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng 1: ");
        int n1 = scanner.nextInt();

        System.out.println("Nhập độ dài của mảng 2: ");
        int n2 = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng thứ 1: ");
        int[] arr1 = new int[n1];
        for ( int i = 0; i < n1;i++) {
            System.out.println("Nhập phần tử thứ " + i + ":");
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Nhập đồ dài phần tử của mảng thứ 2: ");
        int[] arr2 = new int[n2];
        for ( int i = 0; i<n2;i++) {
            System.out.println("Nhập đồ dài phần tử thứ " + i + ":");
            arr2[i] = scanner.nextInt();
        }

        int[] mergedArr = new int[arr1.length + arr2.length];

        System.out.println("Gán các phần tử của mảng arr1 vào mảng mergedArr : ");
        for (int i = 0; i < arr1.length; i++) {
            mergedArr[i] = arr1[i];
        }

        System.out.println("Gán các phần tử của mảng arr2 vào mảng mergedArr, bắt đầu từ vị trí sau cùng của arr1");
        for (int i = 0; i < arr2.length; i++) {
            mergedArr[arr1.length + i] = arr2[i];
        }


        System.out.println("Mảng sau khi gộp:");
        for (int i = 0; i < mergedArr.length; i++) {
            System.out.print(mergedArr[i] + " ");
        }
    }
}

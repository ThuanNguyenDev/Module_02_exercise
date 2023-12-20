package Array;
import java.util.Scanner;
public class InsertElementInArray {

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

        System.out.print("Nhập số cần chèn vào: ");
        int num = scanner.nextInt();

        System.out.print("Nhập vị trí muốn chèn: ");
        int index = scanner.nextInt();

        System.out.println("Mảng sau khi chèn:");
        int[] newArr = insertNumber(arr, num, index);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }

    public static int[] insertNumber(int[] arr, int num, int index) {
        if (index < 0 || index > arr.length) {
            return arr;
        }

        int[] newArray = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            newArray[i] = arr[i];
        }

        newArray[index] = num;

        for (int i = index; i < arr.length; i++) {
            newArray[i + 1] = arr[i];
        }

        return newArray;
    }

}

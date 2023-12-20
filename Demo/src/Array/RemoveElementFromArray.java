package Array;
import java.util.Scanner;
import java.util.Arrays;
public class RemoveElementFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập độ dài của mảng: ");
        int n = scanner.nextInt();

        System.out.println("Nhập các phần tử của mảng:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu là : " + Arrays.toString(arr));

        System.out.println("Nhập phần tử cần xóa : ");
        int elementToRemove = scanner.nextInt();

        int[] newArr = removeElement(arr, elementToRemove);

        System.out.println("Mảng mới:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
    public static int[] removeElement(int[] arr, int elementToRemove) {
        int n = arr.length - 1;
        int[] newArr = new int[n];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != elementToRemove) {
                newArr[index] = arr[i];
                index++;
            }
        }
        return newArr;
    }
}

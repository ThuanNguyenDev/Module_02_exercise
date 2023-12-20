package Demo;

public class ArrayLoopExample {
    public static void main(String[] args) {
        // Khai báo và khởi tạo mảng số nguyên
        int[] numbers = {10, 20, 30, 40, 50};

        // Duyệt qua mảng và in ra các phần tử
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Phần tử thứ " + i + ": " + numbers[i]);
        }
    }
}

package Demo;

public class ArrayExample {
        public static void main(String[] args) {
            // Khai báo mảng số nguyên
            int[] numbers;

            // Tạo mảng có độ dài 5
            numbers = new int[5];

            // Gán giá trị cho các phần tử của mảng
            numbers[0] = 10;
            numbers[1] = 20;
            numbers[2] = 30;
            numbers[3] = 40;
            numbers[4] = 50;

            // Truy cập và in ra các phần tử của mảng
            System.out.println("Phần tử thứ 0: " + numbers[0]);
            System.out.println("Phần tử thứ 1: " + numbers[1]);
            System.out.println("Phần tử thứ 2: " + numbers[2]);
            System.out.println("Phần tử thứ 3: " + numbers[3]);
            System.out.println("Phần tử thứ 4: " + numbers[4]);
        }

}

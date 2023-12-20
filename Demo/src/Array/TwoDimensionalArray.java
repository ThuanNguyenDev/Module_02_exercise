    package Array;
    import java.util.Scanner;
    public class TwoDimensionalArray {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập số dòng của mảng: ");
            int n = scanner.nextInt();

            System.out.println("Nhập số cột của mảng: ");
            int m = scanner.nextInt();

            System.out.println("Nhập các phần tử của mảng: ");
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.println("Nhập phần tử thứ " + i + j + ":");
                    arr[i][j] = scanner.nextInt();
                }
            }
                PrintArray(arr);
            }

                public static void PrintArray(int[][] arr){
                    System.out.println("Mảng hai chiều:");

                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                }


        }

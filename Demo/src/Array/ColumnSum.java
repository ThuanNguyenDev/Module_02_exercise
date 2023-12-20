package Array;

public class ColumnSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int columnIndex = 1; // Ví dụ tính tổng cột thứ 2 (index bắt đầu từ 0)

        int columnSum = calculateColumnSum(matrix, columnIndex);
        System.out.println("Tổng các số ở cột thứ " + (columnIndex + 1) + " là: " + columnSum);
    }
    public static int calculateColumnSum(int[][] matrix, int columnIndex) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][columnIndex];
        }

        return sum;
    }


}

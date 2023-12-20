package Array;
import java.util.Scanner;
public class StudentPassCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm của sinh viên thứ " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        int passCount = countPassStudents(scores);
        System.out.println("Số lượng sinh viên thi đỗ: " + passCount);
    }

    public static int countPassStudents(int[] scores) {
        int passCount = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 5 && scores[i] <=10) {
                passCount++;
            }
        }
        return passCount;
    }
}

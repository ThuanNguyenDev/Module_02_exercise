package Demo;

public class ArrayBreak {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i == 5) {
                break; // Thoát khỏi vòng lặp khi i = 5
            }
        }
        System.out.println("Kết thúc vòng lặp");
    }
}

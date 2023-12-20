package Demo;

public class IfElseExample {
    public static void main(String[] args) {
        int num = 10;

        if (num > 0) {
            System.out.println("Số " + num + " là số dương.");
        } else if (num < 0) {
            System.out.println("Số " + num + " là số âm.");
        } else {
            System.out.println("Số " + num + " là số không.");
        }
    }
}

package Array;
import java.util.Scanner;
public class SearchforAvalueinanArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        System.out.print("Enter Student's name: ");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for ( int i = 0;i <students.length;i++) {
            if(students[i].equals(input_name)) {
                System.out.println("Position of Student in the list " + input_name + "is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found" + input_name + " in the list.");
        }
    }
}

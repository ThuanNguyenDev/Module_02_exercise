import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentList studentList = new StudentList();
        int input;

        do {
            System.out.println("Menu:");
            System.out.println("Vui lòng chọn chức năng: ");
            System.out.println("1. Thêm sinh viên vào danh sách");
            System.out.println("2. In danh sách sinh viên ra màn hình");
            System.out.println("3. Kiểm tra danh sách có rỗng hay không");
            System.out.println("4. Lấy ra số lượng sinh viên trong danh sách");
            System.out.println("5. Làm rỗng danh sách sính viên ");
            System.out.println("6. Kiểm tra sinh viên có tồn tại trong danh sách hay không , dựa trên mã sinh viên");
            System.out.println("7. Xóa một sinh viên khỏi danh sách dựa trên mã sinh viên");
            System.out.println("8. Tìm kiếm tất cả sinh viên dựa trên tên được nhập từ bàn phím");
            System.out.println("9. Xuất ra danh sách sinh viên có điềm từ cao xuống thấp");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.println();
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            scanner.nextLine();

            if (input == 1) {

                System.out.println("Nhập mã sinh viên: ");
                String studentID = scanner.nextLine();
                System.out.println("Nhập Họ và tên sinh viên: ");
                String studentName = scanner.nextLine();
                System.out.println("Nhập điểm trung bình : ");
                float studentGPA = scanner.nextFloat();
                System.out.println("Nhập năm sinh: ");
                int studentDate = scanner.nextInt();


                Student student1 = new Student(studentID,studentName,studentGPA,studentDate);
                studentList.addStudent(student1);

            } else if (input == 2) {
                System.out.println("Danh sách sinh viên: ");
                System.out.println(studentList.printStudentList());
            } else if (input == 3) {
                System.out.println("Danh sách rỗng: " + studentList.isEmpty());
            } else if (input == 4) {
                System.out.println("Lấy số lượng sinh viên: " );
                System.out.println(studentList.getStudentNumber());
            } else if (input == 5) {
                System.out.println("Làm rỗng danh sách sinh viên:");
                System.out.println(studentList.makeEmpty());
            } else if (input == 6) {
                System.out.println("Kiểm tra sinh viên có tồn tại trong danh sách hay không : ");
                System.out.println("Nhập mã sinh viên: ");
                String studentID = scanner.nextLine();
                System.out.println("Nhập Họ và tên sinh viên: ");
                String studentName = scanner.nextLine();
                System.out.println("Nhập điểm trung bình : ");
                float studentGPA = scanner.nextFloat();
                System.out.println("Nhập năm sinh: ");
                int studentDate = scanner.nextInt();

                Student student1 = new Student(studentID,studentName,studentGPA,studentDate);
                System.out.println("Kiểm tra sinh viên có trong danh sách: " + studentList.checkExistStudent(student1));
            } else if (input == 7) {

                System.out.println("Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên : ");
                System.out.println("Nhập mã sinh viên: ");
                String studentID = scanner.nextLine();
                System.out.println("Nhập Họ và tên sinh viên: ");
                String studentName = scanner.nextLine();
                System.out.println("Nhập điểm trung bình : ");
                float studentGPA = scanner.nextFloat();
                System.out.println("Nhập năm sinh: ");
                int studentDate = scanner.nextInt();

                Student student1 = new Student(studentID,studentName,studentGPA,studentDate);
                System.out.println("Xóa sinh viên khỏi danh sách : " + studentList.deleteStudent(student1));

            } else if (input == 8) {
                System.out.println("Tìm tất cả sinh viên dựa trên Tên được nhập từ bàn phím: ");
                System.out.println("Nhập Họ và tên sinh viên: ");
                String studentName = scanner.nextLine();

                System.out.println("Kết quả tìm kiếm: ");
                System.out.println(studentList.checkStudent(studentName));

            } else if (input == 9) {

                System.out.println("Xuất ra danh sách sinh viên có điểm từ cao xuống thấp : ");
                studentList.sortStudentsByScore();
                studentList.printStudentList();
            }
        }
        while (input != 0);
    }
}

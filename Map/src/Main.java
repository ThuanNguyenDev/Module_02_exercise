import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng Map để lưu trữ thông tin sinh viên
        Map<String, Integer> studentScores = new HashMap<>();

        // Thêm thông tin sinh viên vào Map
        studentScores.put("John", 80);
        studentScores.put("Alice", 90);
        studentScores.put("Bob", 75);

        // Truy cập giá trị dựa trên khóa
        int johnScore = studentScores.get("John");
        System.out.println("John's score: " + johnScore);

        // Kiểm tra sự tồn tại của một khóa trong Map
        boolean isAlicePresent = studentScores.containsKey("Alice");
        System.out.println("Is Alice present: " + isAlicePresent);

        // Xóa một phần tử dựa trên khóa
        studentScores.remove("Bob");

        // Duyệt qua các phần tử trong Map
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            System.out.println("Name: " + name + ", Score: " + score);
        }

        // Kiểm tra Map có rỗng hay không
        boolean isEmpty = studentScores.isEmpty();
        System.out.println("Is the map empty: " + isEmpty);

        // Xóa toàn bộ phần tử trong Map
        studentScores.clear();
        System.out.println("Cleared the map. Size: " + studentScores.size());
    }
}
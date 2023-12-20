
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Thêm phần tử vào Queue
        queue.add("A");
        queue.add("B");
        queue.add("C");

        // Truy cập phần tử ở đầu Queue
        String frontElement = queue.peek();
        System.out.println("Phần tử ở đầu Queue: " + frontElement);

        // Xóa phần tử ở đầu Queue
        String removedElement = queue.poll();
        System.out.println("Phần tử bị xóa từ Queue: " + removedElement);

        // Kiểm tra xem Queue có rỗng hay không
        boolean isEmpty = queue.isEmpty();
        System.out.println("Queue rỗng: " + isEmpty);

        // Kích thước của Queue
        int size = queue.size();
        System.out.println("Kích thước của Queue: " + size);

    }
}
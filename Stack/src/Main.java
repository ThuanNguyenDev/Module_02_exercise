
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Thêm phần tử vào Stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Truy cập phần tử ở đỉnh Stack
        int topElement = stack.peek();
        System.out.println("Phần tử ở đỉnh Stack: " + topElement);

        // Xóa phần tử ở đỉnh Stack
        int poppedElement = stack.pop();
        System.out.println("Phần tử bị xóa từ Stack: " + poppedElement);

        // Kiểm tra xem Stack có rỗng hay không
        boolean isEmpty = stack.isEmpty();
        System.out.println("Stack rỗng: " + isEmpty);

        // Kích thước của Stack
        int size = stack.size();
        System.out.println("Kích thước của Stack: " + size);

    }
}
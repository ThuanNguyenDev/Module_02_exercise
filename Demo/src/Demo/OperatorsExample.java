package Demo;

public class OperatorsExample {
    public static void main(String[] args) {
        // Toán tử số học
        int a = 10;
        int b = 5;
        int sum = a + b; // Cộng
        int difference = a - b; // Trừ
        int product = a * b; // Nhân
        int quotient = a / b; // Chia
        int remainder = a % b; // Chia lấy dư

        System.out.println("Toán tử số học:");
        System.out.println("a + b = " + sum);
        System.out.println("a - b = " + difference);
        System.out.println("a * b = " + product);
        System.out.println("a / b = " + quotient);
        System.out.println("a % b = " + remainder);

        // Toán tử gán
        int x = 10;
        x += 5; // Tương đương với x = x + 5

        System.out.println("Toán tử gán:");
        System.out.println("x = " + x);

        // Toán tử so sánh
        int num1 = 10;
        int num2 = 20;
        boolean isEqual = num1 == num2; // So sánh bằng
        boolean isNotEqual = num1 != num2; // So sánh khác
        boolean isGreater = num1 > num2; // So sánh lớn hơn
        boolean isLess = num1 < num2; // So sánh nhỏ hơn
        boolean isGreaterOrEqual = num1 >= num2; // So sánh lớn hơn hoặc bằng
        boolean isLessOrEqual = num1 <= num2; // So sánh nhỏ hơn hoặc bằng

        System.out.println("Toán tử so sánh:");
        System.out.println("num1 == num2: " + isEqual);
        System.out.println("num1 != num2: " + isNotEqual);
        System.out.println("num1 > num2: " + isGreater);
        System.out.println("num1 < num2: " + isLess);
        System.out.println("num1 >= num2: " + isGreaterOrEqual);
        System.out.println("num1 <= num2: " + isLessOrEqual);

        // Toán tử logic
        boolean condition1 = true;
        boolean condition2 = false;
        boolean logicalAnd = condition1 && condition2; // Toán tử AND logic
        boolean logicalOr = condition1 || condition2; // Toán tử OR logic
        boolean logicalNot = !condition1; // Toán tử NOT logic

        System.out.println("Toán tử logic:");
        System.out.println("condition1 && condition2: " + logicalAnd);
        System.out.println("condition1 || condition2: " + logicalOr);
        System.out.println("!condition1: " + logicalNot);
    }
}


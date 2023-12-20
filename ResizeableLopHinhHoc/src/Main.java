import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Object[] shapes = new Object[5];
        Random random = new Random();

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Circle(2.5);
        shapes[3] = new Rectangle(2, 6);
        shapes[4] = new Square(3.7);

        for (Object shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                double initialArea = circle.getArea();
                double resizeRatio = 1 + (random.nextDouble() * 99);
                circle.resize(resizeRatio);
                double finalArea = circle.getArea();

                System.out.println("Diện tích ban đầu: " + initialArea);
                System.out.println("Diện tích sau khi tăng kích thước: " + finalArea);
                System.out.println();
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                double initialArea1 = rectangle.getArea();
                double resizeRatio1 = 1 + (random.nextDouble() * 99);
                rectangle.resize(resizeRatio1);
                double finalArea1 = rectangle.getArea();

                System.out.println("Diện tích ban đầu: " + initialArea1);
                System.out.println("Diện tích sau khi tăng kích thước: " + finalArea1);
                System.out.println();
            } else if (shape instanceof Square) {
                Square square = (Square) shape;
                double initialArea = square.getArea();
                double resizeRatio = 1 + (random.nextDouble() * 99);
                square.resize(resizeRatio);
                double finalArea = square.getArea();

                System.out.println("Diện tích ban đầu: " + initialArea);
                System.out.println("Diện tích sau khi tăng kích thước: " + finalArea);
                System.out.println();
            }
        }
    }
}
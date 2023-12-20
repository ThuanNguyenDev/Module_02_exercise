import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        Random random = new Random();

        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Circle(2.5);
        shapes[3] = new Rectangle(2, 6);
        shapes[4] = new Square(3.7);

        for (Shape shape1 : shapes) {
            double initialArea = shape1.getArea();
            double resizeRatio = 1 + (random.nextDouble() * 99);
            shape1.resize(resizeRatio);
            double finalArea = shape1.getArea();

            System.out.println("Diện tích ban đầu: " + initialArea);
            System.out.println("Diện tích sau khi tăng kích thước: " + finalArea);
            System.out.println();
        }
    }
}
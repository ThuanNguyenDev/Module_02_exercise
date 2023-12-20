
public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5.0);
        Square square = new Square(4.0);
        Rectangle rectangle = new Rectangle(3.0, 6.0);


        double circleArea = circle.calculateArea();
        double squareArea = square.calculateArea();
        double rectangleArea = rectangle.calculateArea();


        System.out.println("Diện tích hình tròn: " + circleArea);
        System.out.println("Diện tích hình vuông: " + squareArea);
        System.out.println("Diện tích hình chữ nhật: " + rectangleArea);
    }
}
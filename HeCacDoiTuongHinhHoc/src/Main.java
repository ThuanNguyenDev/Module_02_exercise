public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle("green",true,3.2);
        CircleArea circle2 = new CircleArea();
        CirclePerimeter circle3 = new CirclePerimeter();
        System.out.println("Diện tích hình tròn : " + circle2.AreaCircle(circle1));
        System.out.println("Chu vi hình tròn : "  + circle3.CirclePerimiter(circle1));

        Rectangle rectangle1 = new Rectangle("black",true,3.2,7.8);
        RectanglePerimiter rectangle2 = new RectanglePerimiter();
        RectangleArea rectangle3 = new RectangleArea();
        System.out.println("Diện tíhc hình chữ nhật là: " + rectangle3.RectangleArea(rectangle1));
        System.out.println("Chu vi hình chữ nhật là : " + rectangle2.RectanglePerimiter(rectangle1));

        Square square1 = new Square("blue",true,2);
        SquareArea square2 = new SquareArea();
        SquarePerimiter square3 = new SquarePerimiter();
        System.out.println("Diện tích hình vuông là : " + square2.SquareArea(square1));
        System.out.println("Chu vi hình vuông là : " + square3.SquarePerimiter(square1));
    }
}
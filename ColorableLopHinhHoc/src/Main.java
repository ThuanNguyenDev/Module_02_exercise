public class Main {
    public static void main(String[] args) {
        GeometricObject[] shapes = new GeometricObject[4];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Square(4.0);
        shapes[2] = new Rectangle(3.0, 6.0);
        shapes[3] = new Triangle(3.0,4.0);

        for (GeometricObject shape : shapes) {
            System.out.println("Area: " + shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
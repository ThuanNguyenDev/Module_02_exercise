public class Main {
    public static void main(String[] args) {

        Shape shape = new Shape();
        Triangle triangle = new Triangle(3.2,4.5,7.8);
        TriangleArea triangle1 = new TriangleArea();
        TrianglePerimiter triangle2 = new TrianglePerimiter();

        System.out.println("Độ dài 3 cạnh của hình Shape là  : " +  shape.toString());
        System.out.println("Độ dài của 3 cạnh tam giác: " + triangle.toString());
        System.out.println("Diện tích hình tam giác là  : " + triangle1.TriangleArea(triangle));
        System.out.println("Chu vi hình tam giác là : " + triangle2.TrianglePerimiter(triangle));


    }
}
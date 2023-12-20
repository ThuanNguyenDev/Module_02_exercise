public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(3.0);

        if (circle1.compareTo(circle2) > 0) {
            System.out.println("Circle 1 is larger than Circle 2");
        } else if (circle1.compareTo(circle2) < 0) {
            System.out.println("Circle 1 is smaller than Circle 2");
        } else {
            System.out.println("Circle 1 is equal to Circle 2");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 4);
        System.out.println("Point: " + point.toString());

        MoveablePoint moveablePoint = new MoveablePoint(1, 2, 2, 3);

        System.out.println("Moveable Point: " + moveablePoint.toString());

        moveablePoint.move();
        System.out.println("After move: " + moveablePoint.toString());
    }
}
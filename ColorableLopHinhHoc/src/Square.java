class Square extends GeometricObject implements Colorable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

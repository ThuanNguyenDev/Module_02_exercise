public class Square implements Resizeable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side*side;
    }

    public void resize(double percent) {
        side *= percent;

    }

}

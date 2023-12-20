class Circle implements Resizeable {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI*radius*radius;
    }

    public void resize(double percent) {
        radius *= percent;
    }
}

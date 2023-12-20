public class TrianglePerimiter {
    public double TrianglePerimiter(Triangle triangle) {
        double trianglePerimiter = triangle.getSide1() + triangle.getSide2() + triangle.getSide3();
        return trianglePerimiter;
    }
}

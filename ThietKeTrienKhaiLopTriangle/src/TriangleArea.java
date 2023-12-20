public class TriangleArea {
    public double TriangleArea(Triangle triangle) {
        double s = (triangle.getSide1()+triangle.getSide2()+triangle.getSide3())/2;
        double triangleArea = Math.sqrt(s * (s - triangle.getSide1()) * (s - triangle.getSide2()) * (s - triangle.getSide3()));
        return triangleArea;
    }
}

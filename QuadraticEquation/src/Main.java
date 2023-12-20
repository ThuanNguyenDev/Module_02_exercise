
public class Main {
    public static void main(String[] args) {
        QuadraticEquation equation1 = new QuadraticEquation(1, -3, 2);
        System.out.println("Quadratic equation 1:");
        System.out.println("a = " + equation1.getA());
        System.out.println("b = " + equation1.getB());
        System.out.println("c = " + equation1.getC());

        System.out.println("Discriminant = " + equation1.getDiscriminant());
        if (equation1.hasRealRoots()) {
            System.out.println("Root 1 = " + equation1.getRoot1());
            System.out.println("Root 2 = " + equation1.getRoot2());
        } else {
            System.out.println("The equation has no real roots.");
        }

        System.out.println();

        QuadraticEquation equation2 = new QuadraticEquation(2, 2, 1);
        System.out.println("Quadratic equation 2:");
        System.out.println("a = " + equation2.getA());
        System.out.println("b = " + equation2.getB());
        System.out.println("c = " + equation2.getC());

        System.out.println("Discriminant = " + equation2.getDiscriminant());
        if (equation2.hasRealRoots()) {
            System.out.println("Root 1 = " + equation2.getRoot1());
            System.out.println("Root 2 = " + equation2.getRoot2());
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}

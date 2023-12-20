package Loop;

public class DesigningRectangle {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 10;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

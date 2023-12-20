public class Main {
    public static void main(String[] args) {
        Object[] objects = new Object[4];
        objects[0] = new Chicken("Chicken");
        objects[1] = new Fruit();
        objects[2] = new Chicken("Rooster");
        objects[3] = new Fruit();

        for (Object object : objects) {
            if (object instanceof Edible) {
                ((Edible) object).howToEat();
            }

            if (object instanceof Animal) {
                System.out.println("Name: " + ((Animal) object).getName());
            }
        }
    }
}
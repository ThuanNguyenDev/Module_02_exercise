public class Chicken extends Animal implements Edible {
    public Chicken(String name) {
        super(name);
    }

    public void howToEat() {
        System.out.println("Cook it and eat it");
    }
}

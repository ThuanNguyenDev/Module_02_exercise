
public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10.0);
        fan1.setColor("yellow");
        fan1.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);

        System.out.println("Fan 1: " + fan1);
        System.out.println("Fan 2: " + fan2);
    }
}


public class Fan {
    // Constants for fan speeds
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Instance variables
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // Constructor
    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5.0;
        color = "blue";
    }

    // Getters and setters for instance variables
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Method to display information about the fan
    public String toString() {
        if (on) {
            return "Speed: " + speed + ", Color: " + color + ", Radius: " + radius;
        } else {
            return "Fan is off, Color: " + color + ", Radius: " + radius;
        }
    }
}

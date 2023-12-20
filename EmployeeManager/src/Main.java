
public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John A", 5000);
        employee1.display();

        Manager manager = new Manager("John D", 5000, 1000);
        manager.display();
        System.out.println("Bonus: " + manager.getBonus());
    }
}
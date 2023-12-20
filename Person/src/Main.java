
public class Main {
    public static void main(String[] args) {
        Person p = new Person(3555, "Thuan", 24, "Ha Noi");
        System.out.println("Id: " + p.getId());
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Address: " + p.getAddress());
    }
}
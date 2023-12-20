public class Person {
    private int id;
    private String name;
    private int age;
    private String address;

    public Person(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getAddress() {
        return this.address;
    }
}

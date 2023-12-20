public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");

        System.out.println("Size: " + myList.size());
        System.out.println("Is Empty: " + myList.isEmpty());

        System.out.println("Element at index 1: " + myList.get(1));

        myList.remove(0);

        System.out.println("Contains 'Item 2': " + myList.contains("Item 2"));
        System.out.println("Contains 'Item 1': " + myList.contains("Item 1"));

        System.out.println("Size: " + myList.size());
    }
}
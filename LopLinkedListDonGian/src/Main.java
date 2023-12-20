public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();

        // Thêm phần tử vào danh sách
        myList.add("Element 1");
        myList.add("Element 2");
        myList.add("Element 3");

        // In danh sách
        System.out.println("Danh sách ban đầu:");
        myList.printList();

        // Lấy phần tử từ danh sách
        String element = myList.get(1);
        System.out.println("Phần tử ở vị trí 1: " + element);

        // Kiểm tra sự tồn tại của phần tử trong danh sách
        boolean contains = myList.contains("Element 2");
        System.out.println("Phần tử 'Element 2' có tồn tại trong danh sách: " + contains);

        // In kích thước của danh sách
        int size = myList.size();
        System.out.println("Kích thước danh sách: " + size);
    }
}

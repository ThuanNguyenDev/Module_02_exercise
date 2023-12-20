public class MyList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size++] = element;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void expandCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }
}

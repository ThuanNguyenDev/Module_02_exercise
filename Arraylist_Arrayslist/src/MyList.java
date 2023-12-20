import java.util.Arrays;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList (int capacity) {
        elements =  new Object[capacity];
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size] = element;
        size++;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}

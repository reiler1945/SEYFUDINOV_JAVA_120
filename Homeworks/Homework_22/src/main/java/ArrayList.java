import java.util.Arrays;
//import java.util.ArrayList;

public class ArrayList<T> extends AbstractList<T> implements List<T> {
    private static int DEFAULT_SIZE = 10;
    private T[] array;
    private int size = 0;

    public ArrayList() {
        this.array = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public T get(int index) {
        if ((index < size) & (index >= 0)) {
            return array[index];
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void removeAt(int index) {
        if ((index < size) & (index >= 0)) {
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(array, index+1, array, index,
                        numMoved);
            array[--size] = null; // clear to let GC do its work
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void insert(T element, int index) {
        if ((index < size) & (index >= 0)) {
            array[index] = element;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void add(T element) {
        if (sizeNotCorrect()) {
            resize();
        }
        array[size++] = element;
    }

    private boolean sizeNotCorrect() {
        return size == array.length;
    }

    void resize() {
        T[] arrayNew = (T[])new Object[array.length + array.length >> 1];
        arrayNew = Arrays.copyOf(array, array.length);
        array = arrayNew;
    }

    @Override
    public void add(T ... element) {
        for (T e : element) {
            add(e);
        }
    }

    @Override
    public boolean remove(T element) {
        if (element == null) {
            for (int index = 0; index < size; index++)
                if (array[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (element.equals(array[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(array, index+1, array, index,
                    numMoved);
        array[--size] = null; // clear to let GC do its work
    }

    @Override
    public boolean contains(T element) {
        for (T e : array) {
            if (e.equals(element))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private class LinkedListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return array[index++];
            }
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}

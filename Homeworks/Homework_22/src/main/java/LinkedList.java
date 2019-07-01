public class LinkedList<T> extends AbstractList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public T get(int index) {
        if ((index < size) & (index >= 0)) {
            return node(index).item;
        } else {
            throw new IllegalArgumentException();
        }
    }

    Node<T> node(int index) {

        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void removeAt(int index) {
        if ((index < size) & (index >= 0)) {
            Node<T> nodeAt = node(index);
            if (nodeAt == first) {
                if (first.next != null) {
                    first = first.next;
                    first.prev = null;
                } else {
                    first = null;
                }
                size--;
                return;
            }
            if (nodeAt == last) {
                if (last.prev != null) {
                    last = last.prev;
                    last.next = null;
                } else {
                    last = null;
                }
                size--;
                return;
            }
            nodeAt.prev.next = nodeAt.next;
            nodeAt.next.prev = nodeAt.prev;
            size--;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void insert(T element, int index) {

    }

    @Override
    public void add(T element) {
        if (size == 0) {
            first = new Node<>(null, element, null);
            last = first;
        } else {
            Node<T> newNode = new Node<>(last, element, null);
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(T... element) {
        for (T e : element) {
            add(e);
        }
    }

    @Override
    public boolean remove(T element) {
        Node<T> currNode = first;
        while (currNode != null) {
            if (currNode.item.equals(element)) {
                if (currNode == first) {
                    if (first.next != null) {
                        first = first.next;
                        first.prev = null;
                    } else {
                        first = null;
                    }
                    size--;
                    return true;
                }
                if (currNode == last) {
                    if (last.prev != null) {
                        last = last.prev;
                        last.next = null;
                    } else {
                        last = null;
                    }
                    size--;
                    return true;
                }
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                size--;
                return true;
            } else {
                currNode = currNode.next;
            };
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currNode = first;
        while (currNode != null) {
            if (currNode.item.equals(element)) {
                return true;
            } else {
                currNode = currNode.next;
            };
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private class LinkedListIterator implements Iterator<T> {

        Node<T> current;

        LinkedListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.item;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}

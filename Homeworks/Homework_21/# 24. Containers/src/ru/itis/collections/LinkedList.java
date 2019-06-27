package ru.itis.collections;

public class LinkedList <T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public T get(int index) {
        T element;
        if ((index >= this.size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        } else {
            int currentIndex = 0;
            Node<T> currentNode = this.head;
            while (currentIndex != index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            element = currentNode.getValue();
        }
        return element;
    }

    public void removeAt(int index) {
        if ((index >= 0) && (index < this.size)) {
            Node<T> previousNode = null;
            Node<T> currentNode = this.head;
            int currentIndex = 0;
            if (index == 0) {
                this.head = currentNode.getNext();
            } else {
                while (currentIndex != index) {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                    currentIndex++;
                }
                previousNode.setNext(currentNode.getNext());
            }
            this.size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(T element) {
        Node <T> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    public boolean exists(T element) {
        boolean result = false;
        Node <T> currentNode = this.head;
        while (currentNode != null) {
            T currentElement = (T) currentNode.getValue();
            if (element.equals(currentElement)) {
                result = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        return result;
    }

    public void remove(T element) {
        Node<T> previousNode = null;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            T currentElement = currentNode.getValue();
            if (element.equals(currentElement)) {
                if (previousNode == null) {
                    this.head = currentNode.getNext();
                    currentNode = this.head;
                } else {
                    previousNode.setNext(currentNode.getNext());
                    currentNode = currentNode.getNext();
                }
                this.size--;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<T> currentNode = this.head;
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode.getValue() + " -> ");
            currentNode = currentNode.getNext();
        }
        result.append("null");
        return result.toString();
    }
}

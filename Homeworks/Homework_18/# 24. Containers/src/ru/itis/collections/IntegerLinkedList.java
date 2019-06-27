package ru.itis.collections;

public class IntegerLinkedList implements IntegersList {
    private Node head;
    private Node tail;
    private int size;

    public IntegerLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int get(int index) {
        int element;
        if ((index >= this.size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        } else {
            int currentIndex = 0;
            Node currentNode = this.head;
            while (currentIndex != index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            element = currentNode.getValue();
        }
        return element;
    }

    @Override
    public void removeAt(int index) {
        if ((index >= 0) && (index < this.size)) {
            Node previousNode = null;
            Node currentNode = this.head;
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

    @Override
    public void add(int element) {
        Node newNode = new Node(element);

        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public boolean exists(int element) {
        boolean result = false;
        Node currentNode = this.head;
        while (currentNode != null) {
            int currentElement = currentNode.getValue();
            if (element == currentElement) {
                result = true;
                break;
            }
            currentNode = currentNode.getNext();
        }
        return result;
    }

    @Override
    public void remove(int element) {
        Node previousNode = null;
        Node currentNode = this.head;
        while (currentNode != null) {
            int currentElement = currentNode.getValue();
            if (element == currentElement) {
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

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node currentNode = this.head;
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode.getValue()).append( " -> ");
            currentNode = currentNode.getNext();
        }
        result.append("null");
        return result.toString();
    }
}

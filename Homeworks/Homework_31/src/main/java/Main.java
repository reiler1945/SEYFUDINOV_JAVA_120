/*
пример
*/
import java.util.*;
class Main {
    public static void main(String args[]){
        Node<String> nodes = new Node<>("0", null);
        nodes.addNode("1");
        nodes.addNode("2");
        nodes.addNode("3");

        nodes.getNodes().get(0).addNode("4");
        nodes.getNodes().get(0).addNode("5");
        nodes.getNodes().get(0).addNode("6");
        //nodes.getNodes().get(0).addNode("X"); //удалить

        nodes.getNodes().get(0).getNodes().get(2).addNode("7");

        System.out.println(nodes.getNodes().get(0).getNodes().get(2).getNodes().get(0).getValue());
        System.out.println(nodes.getNodes().get(0).getNodes().get(2).getNodes().get(0).getRoot().getValue());

        //сколько нужно добавить подотделов?
        System.out.println("Need to add = " + nodes.needAddedNodes());
        nodes.printByLevels();
        int listSize = 3;
        System.out.println("need = " + (int)(Math.ceil(Math.log10(listSize)/Math.log10(2))));
    }
}


class Node<T> {
    private List<Node<T>> nodes;
    private T value;
    private Node<T> root;

    public Node(T value, Node<T> root) {
        this.value = value;
        this.root = root;
        this.nodes = new LinkedList<>();
    }

    public void addNode(T value) {
        nodes.add(new Node<>(value, this));
    };

    public Node<T> getRoot() {
        return this.root;
    }

    public List<Node<T>> getNodes() {
        return this.nodes;
    }

    public T getValue() {
        return this.value;
    }

    public void printByLevels() {
        printByLevels(this, 0);
    }

    public void printByLevels(Node<T> nodeIn, int level) {

        List<Node<T>> list = nodeIn.getNodes();
        int listSize = list.size();
        int middleSize = listSize / 2;

        String spaces = "";
        for (int i = 0; i < level; i++) {
            spaces = spaces + "   ";
        }

        if (listSize == 0) {
            System.out.println(spaces + "--" + nodeIn.getValue());
        } else {
            int i = 0;
            for (Node<T> nodes : list) {
                if (i == middleSize) {
                    System.out.println(spaces + "--" + nodeIn.getValue());
                }
                printByLevels(nodes, level + 1);
                i++;
            };
        }
    }

    public int needAddedNodes() {
        return needAddedNodes(this);
    }

    private int needAddedNodes(Node<T> nodeIn) {
        int result = 0;
        int listSize = nodeIn.getNodes().size();
        if (listSize == 0 || listSize == 1 || listSize == 2) {
            return result;
        } else {
            result = formula(listSize);
            for (Node<T> nodes : nodeIn.getNodes()) {
                result = result + needAddedNodes(nodes);
            };
        }
        return result;
    }

    private int formula(int listSize) {
        return (int)(Math.ceil(Math.log10(listSize)/Math.log10(2)));
    }

}


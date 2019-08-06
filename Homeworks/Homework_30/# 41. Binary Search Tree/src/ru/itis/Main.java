package ru.itis;

public class Main {

    public static void main(String[] args) {
        int res = -7 % 3;
        System.out.println("-7%3 = " + res);

	    int elements[] = {3, 8, 1, 0, 4, 9, 22, 15, 20, 40, 2, 5, 6, 7, 400000, 4000000, 14, 13, 12, 11, 10, 9, 9, 9};
	    Tree<Integer> tree = new TreeBstImpl<>();

	    for (int element : elements) {
	        tree.insert(element);
        }

        int i = 0 ;

	    tree.print();
        System.out.println();

        tree.printByLevels();

        System.out.println("удалили 3 = " + tree.remove(3));
        System.out.println("удалили 1 = " + tree.remove(1));
        System.out.println("удалили 9 = " + tree.remove(9));
        System.out.println("удалили 9 = " + tree.remove(9));
        System.out.println("удалили 20 = " + tree.remove(20));
        System.out.println("удалили 0 = " + tree.remove(0));
        System.out.println("удалили 100 = " + tree.remove(100));

	    tree.print();
        System.out.println();

        System.out.println("дерево BST = " + tree.isBst());

        System.out.println(tree.contains(1));
        System.out.println(tree.contains(50));
        tree.printByLevels();
    }
}

package ru.itis;

/**
 * 05.07.2019
 * TreeBstImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {
    static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }
    }

    // корень
    private Node<T> root;
    private static final String LABEL_BETWEEN_LEVELS = "--";


    @Override
    public void insert(T value) {
        this.root = insert(root, value);
    }

    // вставить новый элемент value в дерево с корнем в root
    // и вернуть этот корень
    private Node<T> insert(Node<T> root, T value) {
        // если корня нет - значит здесь должен быть элемент
        if (root == null) {
            root = new Node<>(value);
        } else if (value.compareTo(root.value)  <= 0) {
            // если новое значение оказалось меньше или равно корню
            // вставляем в левое поддерево
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    @Override
    public void print() {
        print(root);
    }

    private void print(Node<T> root) {
        if (root.left != null) {
            print(root.left);
        }
        System.out.print(root.value + " ");
        if (root.right != null) {
            print(root.right);
        }
    }

    @Override
    public boolean remove(T value) {
        return remove(null, root, value);
    }

    private boolean remove(Node<T> parentNode, Node<T> childNode, T value) {
        if (childNode != null) {
            if (childNode.value.compareTo(value) == 0) {
                if (parentNode != null) {
                    if (parentNode.right == childNode) {
                        if (childNode.right != null) {
                            parentNode.right = childNode.right;
                            findLastLeft(childNode.right).left = childNode.left;
                        } else {
                            parentNode.right = childNode.left;
                        }
                    } else if (parentNode.left == childNode) {
                        if (childNode.right != null) {
                            parentNode.left = childNode.right;
                            findLastLeft(childNode.right).left = childNode.left;
                        } else {
                            parentNode.left = childNode.left;
                        }
                    }
                } else {
                    parentNode = childNode.right;
                    findLastLeft(parentNode).left = childNode.left;
                    this.root = parentNode;
                }
                return true;
            } else if (childNode.value.compareTo(value) > 0) {
                return remove(childNode, childNode.left, value);
            } else {
                return remove(childNode, childNode.right, value);
            }
        } else return false;
    }

    private Node<T> findLastLeft(Node<T> node) {
        if (node != null) {
            if (node.left == null) {
                return node;
            } else {
                return findLastLeft(node.left);
            }
        } else throw new IllegalArgumentException();
    }

    @Override
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> root, T value) {
        if (root != null) {
            if (root.value.compareTo(value) == 0) {
                return true;
            } else if (root.value.compareTo(value) > 0) {
                return contains(root.left, value);
            } else {
                return contains(root.right, value);
            }
        } else return false;
    }

    @Override
    public void printByLevels() {
        StringBuilder stringBuilder = new StringBuilder();
        int backSpaceCount = 0;
        printByLevels(root, 0, null, stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private void printByLevels(Node<T> root, int backSpaceCount, T previousValue, StringBuilder stringBuilder) {
        if (root != null) {
            // подсчет пробелов
            if (previousValue != null) {
                backSpaceCount = backSpaceCount + previousValue.toString().length() + LABEL_BETWEEN_LEVELS.length();
            }

            // правая часть
            if (root.right != null) {
                printByLevels(root.right, backSpaceCount, root.value, stringBuilder);
            }

            // корень
            stringBuilder.append(Utils.repeatString(" ", backSpaceCount)).append(LABEL_BETWEEN_LEVELS).append(root.value).append("\n");

            // левая часть
            if (root.left != null) {
                printByLevels(root.left, backSpaceCount, root.value, stringBuilder);
            }
        }
    }

    @Override
    public boolean isBst() {
        return isBst(this.root);
    }

    private boolean isBst(Node<T> root) {
        if (root == null) {
            return true;
        } else {
            if (root.right != null) {
                if (root.value.compareTo(root.right.value) > 0) {
                    return false;
                } else {
                    return isBst(root.right);
                }
            }
            if (root.left != null) {
                if (root.value.compareTo(root.left.value) <= 0) {
                    return false;
                } else {
                    return isBst(root.left);
                }
            }
            return true;
        }
    }
}



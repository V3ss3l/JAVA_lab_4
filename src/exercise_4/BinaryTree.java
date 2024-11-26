package exercise_4;

public class BinaryTree {
    // Узел дерева
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Корневой узел дерева
    private Node root;

    // Метод для добавления узла
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    // Прямой обход (pre-order)
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // Обратный обход (post-order)
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Центрированный обход (in-order)
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }

    // Метод для вычисления длины дерева (количество узлов)
    public int calculateLength(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + calculateLength(node.left) + calculateLength(node.right);
    }

    // Геттер для корневого узла
    public Node getRoot() {
        return root;
    }

    // Тестирование
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Добавление узлов
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(9);

        System.out.println("Прямой обход (Pre-order):");
        tree.traversePreOrder(tree.getRoot());
        System.out.println();

        System.out.println("Обратный обход (Post-order):");
        tree.traversePostOrder(tree.getRoot());
        System.out.println();

        System.out.println("Центрированный обход (In-order):");
        tree.traverseInOrder(tree.getRoot());
        System.out.println();

        System.out.println("Длина дерева: " + tree.calculateLength(tree.getRoot()));
    }
}


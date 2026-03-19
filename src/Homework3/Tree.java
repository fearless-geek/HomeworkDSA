package Homework3;

public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;


    public void add(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return;
        }

        TreeNode<T> current = root;
        TreeNode<T> parent = null;

        while (current != null) {
            parent = current;
            int cmp = value.compareTo(current.getData());
            if (cmp < 0) current = current.getLeft();
            else if (cmp > 0) current = current.getRight();
            else return;
        }

        TreeNode<T> newNode = new TreeNode<>(value);
        newNode.setParent(parent);

        if (value.compareTo(parent.getData()) < 0) parent.setLeft(newNode);
        else parent.setRight(newNode);
    }


    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode<T> deleteRecursive(TreeNode<T> node, T value) {
        if (node == null) return null;

        int cmp = value.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(deleteRecursive(node.getLeft(), value));
        } else if (cmp > 0) {
            node.setRight(deleteRecursive(node.getRight(), value));
        } else {

            if (node.getLeft() == null) {
                if (node.getRight() != null) node.getRight().setParent(node.getParent());
                return node.getRight();
            } else if (node.getRight() == null) {
                node.getLeft().setParent(node.getParent());
                return node.getLeft();
            }


            T minVal = findMin(node.getRight());
            node.setData(minVal);
            node.setRight(deleteRecursive(node.getRight(), minVal));
        }
        return node;
    }

    private T findMin(TreeNode<T> node) {
        while (node.getLeft() != null) node = node.getLeft();
        return node.getData();
    }

  
    public void printPreOrder(TreeNode<T> node) { // Прямой
        if (node == null) return;
        System.out.print(node.getData() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printInOrder(TreeNode<T> node) { // Симметричный
        if (node == null) return;
        printInOrder(node.getLeft());
        System.out.print(node.getData() + " ");
        printInOrder(node.getRight());
    }

    public void printPostOrder(TreeNode<T> node) { // Обратный
        if (node == null) return;
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.print(node.getData() + " ");
    }

    public TreeNode<T> getRoot() { return root; }
}

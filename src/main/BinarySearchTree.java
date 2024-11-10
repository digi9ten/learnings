package main;

public class BinarySearchTree {

    public static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public Node insertNode(Node node, int value) {
        if (null == node) {
            return new Node(value);

        } else {
            if (value <= node.value) {
                node.left = insertNode(node.left, value);

            } else {
                node.right = insertNode(node.right, value);
            }
        }

        return node;
    }

    public void insert(int... values) {
        for (int value : values) {
            root = insertNode(root, value);
        }
    }

    public int findMinValue(Node start) {
        Node current = start;
        while (null != current.left) {
            current = current.left;
        }

        return current.value;
    }

    public int findMaxValue(Node start) {
        Node current = start;
        while (null != current.right) {
            current = current.right;
        }

        return current.value;
    }

    public int findFloor(Node node, int x) {
        if (null == node) return -1;
        else if (x == node.value) return x;
        else if (x < node.value && null != node.left) {
            return findFloor(node.left, x);
        }

        int floor = null == node.right ? node.value : node.right.value;
        return floor <= x ? floor : node.value;
    }

    public int findCeil(Node node, int x) {
        if (null == node) return -1;
        else if (x == node.value) return x;
        else if (x > node.value && null != node.right) {
            return findCeil(node.right, x);
        }

        int ceil = null == node.left ? node.value : node.left.value;
        return ceil >= x ? ceil : node.value;
    }
}

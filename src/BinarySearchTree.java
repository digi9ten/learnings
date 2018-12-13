public class BinarySearchTree {

    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private Node insertNode(Node node, int value) {
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

    private void insert(int... values) {
        for (int value : values) {
            root = insertNode(root, value);
        }
    }

    private int findMinValue(Node start) {
        Node current = start;
        while (null != current.left) {
            current = current.left;
        }

        return current.value;
    }

    private int findMaxValue(Node start) {
        Node current = start;
        while (null != current.right) {
            current = current.right;
        }

        return current.value;
    }

    private int findFloor(Node node, int x) {
        if (null == node) return -1;
        else if (x == node.value) return x;
        else if (x < node.value && null != node.left) {
            return findFloor(node.left, x);
        }

        int floor = null == node.right ? node.value : node.right.value;
        return floor <= x ? floor : node.value;
    }

    private int findCeil(Node node, int x) {
        if (null == node) return -1;
        else if (x == node.value) return x;
        else if (x > node.value && null != node.right) {
            return findCeil(node.right, x);
        }

        int ceil = null == node.left ? node.value : node.left.value;
        return ceil >= x ? ceil : node.value;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5, 4, 3, 6, 7, 45, 1);
        System.out.println("min value: " + tree.findMinValue(tree.root));
        System.out.println("should be 1");
        System.out.println("max value: " + tree.findMaxValue(tree.root));
        System.out.println("should be 45");
        System.out.println("floor value: " + tree.findFloor(tree.root, 6));
        System.out.println("should be 6");
        System.out.println("ceil value: " + tree.findCeil(tree.root, 9));
        System.out.println("should be 45");

        tree = new BinarySearchTree();
        tree.insert(9, 1, 11, 123);
        System.out.println("min value: " + tree.findMinValue(tree.root));
        System.out.println("should be 9");
        System.out.println("max value: " + tree.findMaxValue(tree.root));
        System.out.println("should be 123");
        System.out.println("floor value: " + tree.findFloor(tree.root, 11));
        System.out.println("should be 11");
        System.out.println("ceil value: " + tree.findCeil(tree.root, 5));
        System.out.println("should be 9");
    }
}

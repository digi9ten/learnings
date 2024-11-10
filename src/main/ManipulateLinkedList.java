package main;

public class ManipulateLinkedList {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            data = d;
            next = null;
        }

        ListNode addNode(ListNode nuNode) {
            if (null == next) {
                next = nuNode;
                return this;
            } else {
                return next.addNode(nuNode);
            }
        }
    }

    private static void removedDups(ListNode node) {
        ListNode nodeA = node, nodeB;

        while (null != nodeA && null != nodeA.next) {
            nodeB = nodeA;

            while (null != nodeB.next) {
                if (nodeA.data == nodeB.next.data) {
                    nodeB.next = nodeB.next.next;
                } else {
                    nodeB = nodeB.next;
                }
            }

            nodeA = nodeA.next;
        }
    }

    private static void printNumbers(String prefix, ListNode node) {
        StringBuilder result = new StringBuilder(prefix + " : ");
        while (null != node.next) {
            result.append(node.data);
            result.append(" - ");
            node = node.next;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(932);
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(8));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(2));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(6));
        printNumbers("before dedup", root);
        removedDups(root);
        printNumbers("after dedup", root);

        root = new ListNode(4);
        root.addNode(new ListNode(67));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(347));
        root.addNode(new ListNode(7));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(3));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(4));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(347));
        root.addNode(new ListNode(347));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(347));
        root.addNode(new ListNode(1));
        root.addNode(new ListNode(4));
        printNumbers("before dedup", root);
        removedDups(root);
        printNumbers("after dedup", root);
    }
}

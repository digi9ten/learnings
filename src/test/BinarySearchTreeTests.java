package test;

import main.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeTests {

    @Test
    void test1() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5, 4, 3, 6, 7, 45, 1);

        assertEquals(1, tree.findMinValue(tree.getRoot()));
        assertEquals(45, tree.findMaxValue(tree.getRoot()));
        assertEquals(6, tree.findFloor(tree.getRoot(), 6));
        assertEquals(45, tree.findCeil(tree.getRoot(), 9));
    }

    @Test
    void test2() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9, 1, 11, 123);

        assertEquals(1, tree.findMinValue(tree.getRoot()));
        assertEquals(123, tree.findMaxValue(tree.getRoot()));
        assertEquals(11, tree.findFloor(tree.getRoot(), 11));
        assertEquals(9, tree.findCeil(tree.getRoot(), 5));
    }
}

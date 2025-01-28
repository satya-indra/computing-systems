package org.example.bfs.tree;

import org.junit.Test;

public class RightViewOfTree {
    @Test
    public void printRightView() {
        BinaryTree tree = initializeTree();

        printTree(tree.root);

    }

    private void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        printTree(root.right);
    }

    private static BinaryTree initializeTree() {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(20);
        tree.add(8);
        tree.add(4);
        return tree;
    }
}

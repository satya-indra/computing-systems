package org.example.bfs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int data) {
        root = findAndAdd(root, data);
    }

    private Node findAndAdd(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = findAndAdd(node.left, data);
        } else {
            node.right = findAndAdd(node.right, data);
        }

        return node;
    }

    public static void main(String[] args) {
        // fill the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(5);;
        root.left.right =  new Node(6);
        root.left.left.right = new Node(8);

        // print the right of the tree
        printRightTree(root);

    }

    private static void printRightTree(Node node) {

        // [1,3,5,null,null....] --> we want to create tree out of it

        System.out.println(node.data);

        Queue<Node> queue = new LinkedList<>();

        queue.add(node.left);
        queue.add(node.right);

        List<Node> nodeList = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            // store the next childs
            if(temp.left != null)
                nodeList.add(temp.left);
            if(temp.right != null)
                nodeList.add(temp.right);

            // check if this is the last element or not
            if (queue.isEmpty()) {
                // then print the result
                System.out.println(temp.data);
            }

            if(queue.isEmpty() && !nodeList.isEmpty()) {
                queue.addAll(nodeList);
                nodeList.clear();
            }

        }

    }
}


class Node {
    Integer data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

}






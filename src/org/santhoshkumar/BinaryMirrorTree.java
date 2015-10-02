package org.santhoshkumar;

public class BinaryMirrorTree {

    Node root;

    public static void main(String[] args) {
        BinaryMirrorTree bmt = new BinaryMirrorTree();
        bmt.root = createBinaryTree();
        bmt.inOrder(bmt.root);
        System.out.println();
        bmt.mirror(bmt.root);
        bmt.inOrder(bmt.root);
        System.out.println();
        bmt.mirror(bmt.root);
        bmt.inOrder(bmt.root);
        System.out.println();

        BinaryMirrorTree leftTree = new BinaryMirrorTree();
        leftTree.root = createBinaryTree();

        BinaryMirrorTree rightTree = new BinaryMirrorTree();
        rightTree.root = createBinaryTree();
        rightTree.mirror(rightTree.root);

        Node newRoot = new Node(100);
        newRoot.left = leftTree.root;
        newRoot.right = rightTree.root;

        BinaryMirrorTree newTree = new BinaryMirrorTree();
        newTree.root = newRoot;
        newTree.inOrder(newRoot);
        System.out.println();
        System.out.println(checkMirror(newTree.root.left, newTree.root.right));
        System.out.println(checkMirror(bmt.root.left, bmt.root.right));
    }

    public static Node createBinaryTree(){
        Node node = new Node(50);
        node.left = new Node(25);
        node.right = new Node(75);

        node.left.left = new Node(20);
        node.left.right = new Node(30);

        node.right.left = new Node(70);
        node.right.right = new Node(80);

        return node;
    }

    public static boolean checkMirror(Node left, Node right){
        if(left == null && right == null){
            return true;
        }
        // if one of the node is null then they are not mirror
        if(left == null || right == null){
            return false;
        }

        if((left.data != right.data)){
            return false;
        }
        return (checkMirror(left.left, right.right) &&
                checkMirror(left.right, right.left));
    }

    // Start with pre order and swap left and right child
    public void mirror(Node node){
        if(node == null){
            return;
        }

        Node swap = node.right;
        node.right = node.left;
        node.left = swap;

        if(node.left != null){
            mirror(node.left);
        }
        if(node.right != null){
            mirror(node.right);
        }
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

}

class Node{
    Node left;
    Node right;
    int data;
    Node(int key){
        data = key;
    }
}
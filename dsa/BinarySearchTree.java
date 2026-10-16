package dsa;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null)
            return false;

        if(root.data == key){
            return true;
        }else if(root.data > key){
           return search(root.left, key);
        }
        else{
           return search(root.right, key);
        }

    }

    public static Node delete(Node root, int key){
        if (root == null)
            return null;
        if (root.data == key) {

            //case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            //case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 3
            Node IS = inorderSucceessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        } else if (root.data > key) {
            root.left =delete(root.left, key);
        } else {
            root.right = delete(root.right, key);
        }

        return root;

    }

    public static Node inorderSucceessor(Node root){
        while (root.left != null) {
            root = root.left;
        }

        return root;

    }

    public static void printInRange(Node root, int x, int y){
        if(root == null)
            return;

        if(root.data >= x && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }else if(root.data > y){
            printInRange(root.left, x, y);
        }else{
            printInRange(root.right, x, y);
        }
    }

    public static void printRootToLeafPaths(Node root,List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        
        //leaf
        if(root.left == null && root.right == null){
            printPath(path);
        }else{//non-leaf
            printRootToLeafPaths(root.left, path);
            printRootToLeafPaths(root.right, path);
        }
        path.remove(path.size()-1);

        
    }

    public static void printPath(List<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) +" -> ");
        }

        System.out.println();
    }
    public static void main(String[] args) {
        // int[] nums = {5, 1, 3, 4, 2, 7};
        int[] nums = {8, 5, 3, 6, 10, 11, 14};

        Node root = null;

        for(int i=0; i<nums.length; i++){
            root = insert(root, nums[i]);
        }

       
        inorder(root);
        System.out.println();

        // System.out.println();
        // if(search(root, 5)){
        //     System.out.println("Key Found");
        // }else{
        //     System.out.println("Key not found");
        // }
        // System.out.println("print in range");
        // printInRange(root, 4, 5);

        // delete(root, 4);

        // System.out.println();
        // inorder(root);

        printRootToLeafPaths(root, new ArrayList<>());
    }
}

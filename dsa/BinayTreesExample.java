package dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BinayTreesExample {
    public static class Node {
            int data;
            Node leftNode;
            Node rightNode;

            Node(int data){
                this.data = data;
                leftNode = rightNode = null;
            }
        }

    static class BinaryTree {
        public static int idx = -1;

        public Node buildTree(int[] nodes){
            idx++;

            if(nodes[idx] == -1)
                return null;

            Node newNode = new Node(nodes[idx]);

            newNode.leftNode = buildTree(nodes);
            newNode.rightNode = buildTree(nodes);

            return newNode;
        }

        public void preorder(Node root){
            if(root == null)
                return;

            System.out.print(root.data);
            preorder(root.leftNode);
            preorder(root.rightNode);
        }

        public void inorder(Node root){
            if(root == null)
                return;

            inorder(root.leftNode);
            System.out.print(root.data);
            inorder(root.rightNode);
        }

        public void postorder(Node root){
            if(root == null)
                return;

            postorder(root.leftNode);
            postorder(root.rightNode);
            System.out.print(root.data);
        }

        public void levelOrder(Node root){
            if(root == null)
                return;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (queue != null) {
                Node currNode = queue.remove();

                if(currNode == null){
                    System.out.println();
                    if(queue.isEmpty()){
                        break;
                    }else{
                        queue.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.leftNode != null){
                        queue.add(currNode.leftNode);
                    }
                    if(currNode.rightNode != null){
                        queue.add(currNode.rightNode);
                    }
                }
            }
        }

        public int countOfNodes(Node root){
            if (root == null) {
                return 0;
            }

            int leftCount = countOfNodes(root.leftNode);
            int rightCount = countOfNodes(root.rightNode);
            return leftCount + rightCount + 1;
        }

        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumOfNodes(root.leftNode);
            int rightSum = sumOfNodes(root.rightNode);
            return leftSum + rightSum + root.data;
        }

        public int height(Node root){
            if(root == null)
                return 0;

            int leftHeight = height(root.leftNode);
            int rightHeight = height(root.rightNode);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public int diameter(Node root){
            if(root == null)
                return 0;

            int dia1 = diameter(root.leftNode);
            int dia2 = diameter(root.rightNode);
            int dia3 = height(root.leftNode) + height(root.rightNode) + 1;

            return Math.max(dia3, Math.max(dia1, dia2));
        }

        static class TreeInfo {
            int ht;
            int diam;

            TreeInfo(int ht, int diam){
                this.ht = ht;
                this.diam = diam;
            }
            
        }

        public TreeInfo diameter2(Node root){
            if(root == null)
                return new TreeInfo(0, 0);

            TreeInfo left = diameter2(root.leftNode);
            TreeInfo right = diameter2(root.rightNode);

            int myHeight = Math.max(left.ht, right.ht) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.ht + right.ht + 1;

            int myDiam = Math.max(Math.max(diam1, diam2), diam3);

            TreeInfo nInfo = new TreeInfo(myHeight, myDiam);

            return nInfo;
        }

        public int sumOfNodesAtK(Node root, int k){
            //this function returns sum of nodes at level k
            // think level of root node is 1
            // Example: if k=3, it returns sum of nodes at level 3
            // Approach: Recursion
            // if k=1, return root.data
            // else, go to left and right subtree with k-1
            // add the results
            // Time Complexity: O(n)
            // Space Complexity: O(h) where h is height of tree
            // Base case
            if(root == null)
                return 0;

            if(k == 1)
                return root.data;

            int leftSum = sumOfNodesAtK(root.leftNode, k-1);
            int rightSum = sumOfNodesAtK(root.rightNode, k-1);

            return leftSum + rightSum;
        }

        public int sumOfNodesAtKIterative(Node root, int k){
            //this function returns sum of nodes at level k
            // think level of root node is 1
            // Example: if k=3, it returns sum of nodes at level 3
            // Approach: Iterative using Queue
            // Time Complexity: O(n)
            // Space Complexity: O(w) where w is max width of tree
            if(root == null)
                return 0;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            int level = 1;
            int sum = 0;

            while(!queue.isEmpty()){
                Node currNode = queue.remove();

                if(currNode == null){
                    //level complete
                    if(queue.isEmpty()){
                        break;
                    }else{
                        queue.add(null);
                        level++;
                    }
                }else{
                    if(level == k){
                        sum += currNode.data;
                    }
                    if(currNode.leftNode != null){
                        queue.add(currNode.leftNode);
                    }
                    if(currNode.rightNode != null){
                        queue.add(currNode.rightNode);
                    }
                }
            }

            return sum;
        }

        public int sumOfNodesAtKSizeBased(Node root, int k) {

            if (root == null)
                return 0;

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;

                for (int i = 0; i < size; i++) {
                    Node curr = queue.poll();

                    if (level == k)
                        sum += curr.data;

                    if (curr.leftNode != null)
                        queue.offer(curr.leftNode);

                    if (curr.rightNode != null)
                        queue.offer(curr.rightNode);
                }

                if (level == k)
                    return sum;

                level++;
            }

            return 0;
        }

        public boolean isSubtree(Node root, Node subRoot){
            if(subRoot == null)
                return true;

            if(root == null){
                return false;
            }

            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }

            return isSubtree(root.leftNode, subRoot) || isSubtree(root.rightNode, subRoot);
        }

        public boolean isIdentical(Node root, Node subRoot){
            if(root == null && subRoot == null)
                return true;

            if(root == null || subRoot == null)
                return false;

            if(root.data == subRoot.data){
                return isIdentical(root.leftNode, subRoot.leftNode) && isIdentical(root.rightNode, subRoot.rightNode);
            }

            return false;
        }

        public boolean isSubtree2(Node s, Node t) {
            if (s == null) {
                return false;
            }
            if (isSameTree(s, t)) {
                return true;
            }
            return isSubtree2(s.leftNode, t) || isSubtree2(s.rightNode, t);
        }   
        private boolean isSameTree(Node s, Node t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.data != t.data) {
                return false;
            }
            return isSameTree(s.leftNode, t.leftNode) && isSameTree(s.rightNode, t.rightNode);
        }

    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree binaryTree = new BinaryTree();
        Node root =binaryTree.buildTree(nodes);
        System.out.println(binaryTree.sumOfNodesAtKSizeBased(root, 3));
    }
}

package dsa;

//This class to demonstrate subtree example
//There are two tree nodes and we have to check whether one tree is subtree of another tree
public class SubtreeExample {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        SubtreeExample example = new SubtreeExample();
        TreeNode s = example.new TreeNode(3);
        s.left = example.new TreeNode(4);
        s.right = example.new TreeNode(5);
        s.left.left = example.new TreeNode(1);
        s.left.right = example.new TreeNode(2);
        s.left.right.left = example.new TreeNode(0);

        TreeNode t = example.new TreeNode(4);
        t.left = example.new TreeNode(1);
        t.right = example.new TreeNode(2);

        boolean result = example.isSubtree(s, t);
        System.out.println("Is t a subtree of s? " + result);
    }
}

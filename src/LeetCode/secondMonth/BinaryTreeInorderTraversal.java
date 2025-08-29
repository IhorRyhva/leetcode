package LeetCode.secondMonth;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    private ArrayList<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return result;

        if(root.left != null) inorderTraversal(root.left);
        result.add(root.val);
        if(root.right != null) inorderTraversal(root.right);

        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
        }
    }
}

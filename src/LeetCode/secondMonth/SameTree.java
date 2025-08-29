package LeetCode.secondMonth;

import java.util.ArrayList;
import java.util.List;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        TreeInorderTraver traverP = new TreeInorderTraver();
        TreeInorderTraver traverQ = new TreeInorderTraver();
        ArrayList<Integer> pList = traverP.inOrderTraver(p);
        ArrayList<Integer> qList = traverQ.inOrderTraver(q);
        return pList.equals(qList);
    }

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
class TreeInorderTraver {
    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> inOrderTraver(TreeNode treeNode){
        if(treeNode == null) return result;

        if(treeNode.left != null){
            inOrderTraver(treeNode.left);
        }else{
            result.add(null);
        }
        if(treeNode.right != null) inOrderTraver(treeNode.right);
        result.add(treeNode.val);

        return result;
    }

}

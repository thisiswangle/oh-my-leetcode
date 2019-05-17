package s100_same_tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;
        List<TreeNode> ptree = new ArrayList<>();
        List<TreeNode> qtree = new ArrayList<>();
        preOrderTraversalCompare(p, ptree);
        preOrderTraversalCompare(q, qtree);
        if (qtree.size() != ptree.size())
            return false;

        for (int i = 0; i < ptree.size(); i ++) {
            TreeNode pnode = ptree.get(i);
            TreeNode qnode = qtree.get(i);
            if (pnode.val != qnode.val)
                return false;
            if (pnode.left == null && qnode.left != null)
                return false;
            if (pnode.left != null && qnode.left == null)
                return false;
            if (pnode.right == null && qnode.right != null)
                return false;
            if (pnode.right != null && qnode.right == null)
                return false;
        }
        return true;
    }

    private void preOrderTraversalCompare(TreeNode p, List<TreeNode> treeNodeList) {
        if (p == null)
            return;

        treeNodeList.add(p);
        TreeNode left = p.left;
        TreeNode right = p.right;
        if (left == null && right == null) {
            return;
        }

        preOrderTraversalCompare(left, treeNodeList);
        preOrderTraversalCompare(right, treeNodeList);
    }
}

package s094_binary_tree_inorder_traversal;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> solution = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null) {
            if (curr.left == null) {
                solution.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    solution.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return solution;
    }
}

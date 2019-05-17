package s104_maximum_depth_of_binary_tree;

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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        inOrder(root);
        return maxDepth;
    }

    private int depth = 0;
    private int maxDepth = 0;
    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        depth ++;
        if (depth > maxDepth)
            maxDepth = depth;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            depth --;
            return;
        }

        inOrder(left);
        inOrder(right);
        depth --;
    }
}
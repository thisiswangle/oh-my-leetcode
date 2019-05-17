package s101_symmetric_tree;


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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode[] ref = new TreeNode[] {root};
        int i = 1;
        while (ref != null) {
            // Not root
            if (ref.length != 1) {
                int mid = ref.length / 2;
                for (int k = mid; k < ref.length; k++) {
                    TreeNode a = ref[k];
                    TreeNode b = ref[mid - (k - (mid - 1))];
                    if (a != null && b != null)
                        if (a.val != b.val)
                            return false;
                    if (a == null || b == null) {
                        if (!(a == null && b == null))
                            return false;
                    }
                }
            }

            // Next level
            i *= 2;
            TreeNode[] levelref = new TreeNode[i];
            for (int j = 0; j < ref.length; j ++) {
                if (ref[j] != null) {
                    levelref[2 * j] = ref[j].left;
                    levelref[2 * j + 1] = ref[j].right;
                } else {
                    levelref[2 * j] = null;
                    levelref[2 * j + 1] = null;
                }
            }

            boolean end = true;
            for (TreeNode n : levelref) {
                if (n != null)
                    end = false;
            }
            if (end)
                ref = null;
            else
                ref = levelref;
        }
        return true;
    }
}
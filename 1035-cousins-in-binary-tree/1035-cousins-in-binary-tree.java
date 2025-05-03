/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int xIndex = -1, yIndex = -1;
    TreeNode xParent = null, yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs (root, 0, x, y, null);
        return xIndex == yIndex && xParent != yParent;
    }

    void dfs (TreeNode root, int currentDepth, int x, int y, TreeNode previous) {
        if (root == null || (xIndex != -1 && yIndex != -1)) {
            return;
        }

        if (root.val == x) {
            xIndex = currentDepth;
            xParent = previous;
        }
        if (root.val == y) {
            yIndex = currentDepth;
            yParent = previous;
        }

        dfs (root.left, currentDepth + 1, x, y, root);
        dfs (root.right, currentDepth + 1, x, y, root);
    }
}
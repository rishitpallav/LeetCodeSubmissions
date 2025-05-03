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
    int xIndex = Integer.MAX_VALUE, yIndex = Integer.MAX_VALUE;
    TreeNode xParent = null, yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs (root, 0, x, y, null);
        return xIndex == yIndex && xParent != yParent;
    }

    void dfs (TreeNode root, int currentDepth, int x, int y, TreeNode previous) {
        if (root == null || (xIndex != Integer.MAX_VALUE && yIndex != Integer.MAX_VALUE) || (currentDepth > xIndex) || (currentDepth > yIndex)) {
            return;
        }

        if (root.val == x) {
            xIndex = currentDepth;
            xParent = previous;
            return;
        }
        if (root.val == y) {
            yIndex = currentDepth;
            yParent = previous;
            return;
        }

        dfs (root.left, currentDepth + 1, x, y, root);
        dfs (root.right, currentDepth + 1, x, y, root);
    }
}
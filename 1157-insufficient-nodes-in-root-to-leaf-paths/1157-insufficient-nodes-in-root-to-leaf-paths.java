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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (chopNodes(root, limit, 0)) {
            return null;
        }
        return root;
    }

    boolean chopNodes(TreeNode root, int limit, int currentSum) {
        if (root == null) {
            if (currentSum < limit) {
                return true;
            } else {
                return false;
            }
        }

        currentSum += root.val;

        boolean left = chopNodes(root.left, limit, currentSum);
        boolean right = chopNodes(root.right, limit, currentSum);

        if (left && right || (left && root.right == null) || (right && root.left == null)) return true;
        if (left) root.left = null;
        if (right) root.right = null;

        return false;
    }
}
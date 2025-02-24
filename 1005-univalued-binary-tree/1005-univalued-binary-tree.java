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
    public boolean isUnivalTree(TreeNode root) {
        return !hasMoreThanOneValue(root, root.val);
    }

    public boolean hasMoreThanOneValue(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        if (root.val != value) {
            return true;
        }

        return hasMoreThanOneValue(root.left, value) || hasMoreThanOneValue(root.right, value);
    }
}
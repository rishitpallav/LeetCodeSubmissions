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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasSum(root, targetSum, 0);
    }

    public boolean hasSum(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == currentSum + root.val;
        }
        currentSum += root.val;
        return hasSum(root.left, targetSum, currentSum) || hasSum(root.right, targetSum, currentSum);
    }
}
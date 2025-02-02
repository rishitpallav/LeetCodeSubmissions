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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return result;
    }
    public int maxSum(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);

        result = Math.max(result, Math.max(left + right + root.val, Math.max(left, right) + root.val));

        return Math.max(Math.max(Math.max(left, right) + root.val, root.val), 0);
    }
}
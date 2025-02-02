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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        returnMax(root);
        return result;
    }
    public int returnMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = returnMax(root.left);
        int right = returnMax(root.right);
        result = Math.max(result, right + left);
        return 1 + Math.max(right, left);
    }
}
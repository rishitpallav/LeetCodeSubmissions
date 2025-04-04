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
    int maxDepth = 0;
    TreeNode result;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        result = root;
        postOrderDepth (root, 0);
        return result;
    }

    int postOrderDepth (TreeNode root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (root == null) {
            return depth;
        }

        int left = postOrderDepth (root.left, depth + 1);
        int right = postOrderDepth (root.right, depth + 1);

        if (left == maxDepth && right == maxDepth) {
            result = root;
        }

        return Math.max(left, right);
    }
}
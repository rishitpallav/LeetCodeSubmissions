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
    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return result;
    }

    public int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{1001, 0};
        }
        int[] left = longestPath(root.left);
        int[] right = longestPath(root.right);

        int count = 0;
        if (root.val == left[0]) {
            count += left[1];
        } else {
            left[1] = 0;
        }
        if (root.val == right[0]) {
            count += right[1];
        } else {
            right[1] = 0;
        }
        result = Math.max(result, count);
        return new int[] {root.val, 1+Math.max(left[1], right[1])};
    }
}
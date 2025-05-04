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
    int counter;
    public int averageOfSubtree(TreeNode root) {
        counter = 0;
        findAverageNodes(root);
        return counter;
    }

    int[] findAverageNodes(TreeNode root) {
        // Let's take 0th index sum and 1st index total nodes
        if (root == null) {
            return new int[]{0,0};
        }

        int[] left = findAverageNodes(root.left);
        int[] right = findAverageNodes(root.right);

        int sum = left[0] + right[0] + root.val;
        int nodes = left[1] + right[1] + 1;

        int average = sum / nodes;

        if (average == root.val) {
            counter++;
        }

        return new int[]{sum, nodes};
    }
}
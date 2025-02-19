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
    long[] totalSum;
    int[] count;

    public List<Double> averageOfLevels(TreeNode root) {
        int height = findHeight(root);

        totalSum = new long[height];
        count = new int[height];

        iterate(root, 0);

        List<Double> result = new ArrayList<>();

        for (int i = 0; i < count.length; i++ ) {
            result.add((double)totalSum[i]/(double)count[i]);
        }

        return result;

    }

    void iterate(TreeNode root, int row) {
        if (root == null) {
            return;
        }
        count[row]++;
        totalSum[row] += root.val;

        iterate(root.left, row+1);
        iterate(root.right, row+1);
    }

    int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    TreeNode construct(int[] nums, int left, int right) {
        if (left > right || left < 0 || right >= nums.length) {
            return null;
        }
        int maxValueIndex = left;
        for (int i = left; i <= right; i++ ) {
            if (nums[maxValueIndex] < nums[i]) {
                maxValueIndex = i;
            }
        }
        TreeNode current = new TreeNode(nums[maxValueIndex]);

        current.left = construct(nums, left, maxValueIndex-1);
        current.right = construct(nums, maxValueIndex+1, right);

        return current;
    }
}
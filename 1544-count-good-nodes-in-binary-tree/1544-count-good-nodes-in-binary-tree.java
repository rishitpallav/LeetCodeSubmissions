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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    int goodNodes(TreeNode root, int highestPrevious) {
        if (root == null) {
            return 0;
        }

        int count = (highestPrevious <= root.val)?1:0;

        highestPrevious = Math.max(highestPrevious, root.val);

        count += goodNodes(root.left, highestPrevious);
        count += goodNodes(root.right, highestPrevious);
        
        return count;
    }
}
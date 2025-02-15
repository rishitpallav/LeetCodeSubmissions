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
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        search(root, "");
        return result;
    }

    public void search(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            s = s + root.val;
            result.add(s.toString());
            return;
        }
        s = s + root.val + "->";
        if (root.left != null) {
            search(root.left, s);
        }
        if (root.right != null) {
            search(root.right, s);
        }
    }
}
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
    List<Integer> tree1Leaves;
    List<Integer> tree2Leaves;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        tree1Leaves = new ArrayList<>();
        tree2Leaves = new ArrayList<>();

        iterateTree(root1, tree1Leaves);
        iterateTree(root2, tree2Leaves);

        return tree1Leaves.equals(tree2Leaves);
    }

    void iterateTree(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        iterateTree(root.left, leaves);
        iterateTree(root.right, leaves);
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> iterations = new LinkedList<>();
        if (root != null)
            iterations.add(root);

        while (!iterations.isEmpty()) {
            int currentSub = 0;

            Queue<TreeNode> nextIterations = new LinkedList<>();

            while (!iterations.isEmpty()) {
                TreeNode current = iterations.poll();
                currentSub = current.val;
                if (current.left != null) nextIterations.add(current.left);
                if (current.right != null) nextIterations.add(current.right);
            }

            iterations = nextIterations;
            result.add(currentSub);

        }

        return result;
    }
}
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
    
    public TreeNode recoverFromPreorder(String traversal) {

        String[] traversals = traversal.split("-");
        TreeNode root = new TreeNode(Integer.parseInt(traversals[0]));

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int d = 1;

        for (int i = 1; i < traversals.length; i++ ) {
            if (traversals[i].equals("")) {
                d++;
            } else {
                while (stack.size() > d) {
                    stack.pop();
                }
                stack.push(insertNode(stack.peek(), Integer.parseInt(traversals[i])));
                d = 1;
            }
        }
        
        return root;
    }

    TreeNode insertNode(TreeNode root, int val) {
        if (root.left == null) {
            root.left = new TreeNode(val);
            return root.left;
        } else {
            root.right = new TreeNode(val);
            return root.right;
        }
    }
}
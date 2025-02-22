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

        int index = 0;
        Stack<TreeNode> stack = new Stack<>();

        while (index < traversal.length() ) {
            
            int depth = 0;

            while (traversal.charAt(index) == '-') {
                depth++;
                index++;
            }

            int val = 0;
            while(index < traversal.length() && traversal.charAt(index) != '-') {
                val = (val * 10) + (traversal.charAt(index) - '0');
                index++;
            }
            
            TreeNode node = new TreeNode(val);

            if (depth == 0) {
                stack.push(node);
                continue;
            }

            while (stack.size() > depth) {
                stack.pop();
            }

            stack.push(insertNode(stack.peek(), val));
        }

        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.peek();
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
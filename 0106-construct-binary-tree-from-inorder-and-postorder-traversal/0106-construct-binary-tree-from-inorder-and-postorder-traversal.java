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
    
    int index;
    Map<Integer, Integer> elements;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        elements = new HashMap<>();

        for (int i = 0; i < inorder.length; i++ ) {
            elements.put(inorder[i], i);
        }

        return construct(inorder, postorder, 0, postorder.length);

    }

    TreeNode construct(int[] inorder, int[] postorder, int start, int end) {
        if (end - start < 1) {
            return null;
        }

        if (end - start == 1) {
            return new TreeNode(postorder[index--]);
        }

        TreeNode current = new TreeNode(postorder[index]);

        int i = elements.get(postorder[index]);
        index--;

        current.right = construct(inorder, postorder, i+1, end);
        current.left = construct(inorder, postorder, start, i);

        return current;
    }
}
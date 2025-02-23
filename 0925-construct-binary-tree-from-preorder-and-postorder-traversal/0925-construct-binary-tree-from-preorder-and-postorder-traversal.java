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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        index = 0;
        elements = new HashMap<>();

        for (int i = 0; i < postorder.length; i++ ) {
            elements.put(postorder[i], i);
        }

        return construct(preorder, postorder, 0, postorder.length);
    }

    TreeNode construct(int[] preorder, int[] postorder, int start, int end) {
        if (end - start < 1) {
            return null;
        }

        if (end - start == 1) {
            return new TreeNode(preorder[index++]);
        }

        TreeNode current = new TreeNode(preorder[index++]);

        int i = elements.get(preorder[index]);

        current.left = construct(preorder, postorder, start, i+1);
        current.right = construct(preorder, postorder, i+1, end - 1);
        return current;
    }
}
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
    int index = 0;
    Map<Integer, Integer> elements;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        elements = new HashMap<>();

        for (int i = 0; i < inorder.length; i++ ) {
            elements.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, inorder.length);
    }

    TreeNode construct(int[] preorder, int[] inorder, int start, int end) {
        
        if (end - start < 1) {
            return null;
        }
        
        if (end - start == 1) {
            index++;
            return new TreeNode(inorder[start]);
        }

        
        // linear search:
        // int i = start;
        // for (i = start; i < end; i++ ) {
        //     if (inorder[i] == preorder[index]) {
        //         break;
        //     }
        // }

        // pre-computed elements
        int i = elements.get(preorder[index]);


        TreeNode current = new TreeNode(inorder[i]);
        index++;

        current.left = construct(preorder, inorder, start, i);
        current.right = construct(preorder, inorder, i+1, end);

        return current;
    }
}
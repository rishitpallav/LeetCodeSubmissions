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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        
        int height = findHeight(root) - 1;

        int m = height + 1;
        int n = (int) Math.pow(2, height + 1) - 1;

        for (int i = 0; i < m; i++ ) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < n; j++ ) {
                temp.add("");
            }
            result.add(temp);
        }

        iterate(root, result, 0, 0, n);

        return result;
        
    }

    void iterate(TreeNode root, List<List<String>> result, int row, int colLeft, int colRight) {
        if (root == null) {
            return;
        }

        int mid = colLeft + (colRight - colLeft)/2;

        result.get(row).set(mid, String.valueOf(root.val));

        iterate(root.left, result, row+1, colLeft, mid-1);
        iterate(root.right, result, row+1, mid+1, colRight);
    }

    int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}
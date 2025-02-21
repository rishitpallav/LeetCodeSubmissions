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
class FindElements {

    Set<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        populateValues(root, 0);
    }

    void populateValues(TreeNode root, int currentValue) {
        if (root == null) {
            return;
        }
        values.add(currentValue);
        populateValues(root.left, 2 * currentValue + 1);
        populateValues(root.right, 2 * currentValue + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
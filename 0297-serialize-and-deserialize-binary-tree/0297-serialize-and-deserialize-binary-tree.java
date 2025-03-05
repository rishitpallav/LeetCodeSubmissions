/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int pointer;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }

        String left = serialize(root.left);
        String middle = String.valueOf(root.val);
        String right = serialize(root.right);

        return middle + ","+ left +"," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        pointer = 0;
        String[] dataArr = data.split(",");
        
        return constructTree(dataArr, new TreeNode()).left;
    }

    TreeNode constructTree(String[] data, TreeNode root) {
        if (pointer == data.length) {
            return null;
        }

        if (data[pointer].equals("N")) {
            pointer++;
            root.left = null;
        } else {
            root.left = new TreeNode(Integer.parseInt(data[pointer++]));
            constructTree(data, root.left);
        }

        if (pointer == data.length) {
            return root;
        }

        if (data[pointer].equals("N")) {
            pointer++;
            root.right = null;
        } else {
            root.right = new TreeNode(Integer.parseInt(data[pointer++]));
            constructTree(data, root.right);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
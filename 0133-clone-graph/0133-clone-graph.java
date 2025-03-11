/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node root = new Node();
        Map<Integer, Node> visited = new HashMap<>();

        dfs(root, node, visited);

        return root;
    }

    Node dfs(Node root, Node node, Map<Integer, Node> visited) {
        if (node == null) {
            return null;
        }

        root.val = node.val;
        visited.put(root.val, root);
        root.neighbors = new ArrayList<>();

        for (Node neighbor : node.neighbors) {
            Node next;
            if (!visited.containsKey(neighbor.val)) {
                next = dfs(new Node(), neighbor, visited);
            } else {
                next = visited.get(neighbor.val);
            }
            root.neighbors.add(next);
        }

        return root;
    }
}
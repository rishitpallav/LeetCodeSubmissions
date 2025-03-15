class Solution {
    
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;

        parent = new int[n+1];
        rank = new int[n+1];
        
        for (int i = 1; i < n+1; i++ ) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }

        return new int[]{};
    }

    int find(int root) {
        if (parent[root] != root) {
            return find(parent[root]);
        }
        return root;
    }

    void union(int node1, int node2) {
        int node1Root = find(node1);
        int node2Root = find(node2);

        if (rank[node1Root] > rank[node2Root]) {
            parent[node2Root] = node1Root;
        } else if (rank[node1Root] < rank[node2Root]) {
            parent[node1Root] = node2Root;
        } else {
            parent[node2Root] = node1Root;
            rank[node1Root]++;
        }
    }
}

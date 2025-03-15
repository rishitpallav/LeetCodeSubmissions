class Solution {
    
    int[] unionMap;
    int[] rank;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        unionMap = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++ ) {
            unionMap[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return find(source) == find(destination);
    }

    int find(int current) {
        if (unionMap[current] != current) {
            return find(unionMap[current]);
        }
        return current;
    }

    void union(int node1, int node2) {

        int node1Root = find(node1);
        int node2Root = find(node2);

        if (rank[node1Root] > rank[node2Root]) {
            unionMap[node2Root] = node1Root;
        } else if (rank[node1Root] < rank[node2Root]) {
            unionMap[node1Root] = node2Root;
        } else {
            unionMap[node2Root] = node1Root;
            rank[node1Root]++;
        }
    }
}
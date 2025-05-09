class Solution {

    List<List<Integer>> result;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> neighbours = new HashMap<>();
        boolean[] visited = new boolean[n];
        int[] timestampAtNode = new int[n];
        result = new ArrayList<>();
        time = 0;

        for (List<Integer> connection : connections) {
            neighbours.computeIfAbsent(connection.get(0), k -> new ArrayList<>()).add(connection.get(1));
            neighbours.computeIfAbsent(connection.get(1), k -> new ArrayList<>()).add(connection.get(0));
        }
        
        dfs(neighbours, 0, -1, timestampAtNode, visited);

        return result;

    }

    void dfs (Map<Integer, List<Integer>> neighbours, int currentNode, int parent, int[] timestampAtNode, boolean[] visited) {
        visited[currentNode] = true;
        timestampAtNode[currentNode] = time++;
        int currentTimestamp = timestampAtNode[currentNode];

        for (int neighbour : neighbours.getOrDefault(currentNode, new ArrayList<>())) {
            if (neighbour == parent) continue;
            if (!visited[neighbour]) {
                dfs (neighbours, neighbour, currentNode, timestampAtNode, visited);
            }   
            timestampAtNode[currentNode] = Math.min(timestampAtNode[currentNode], timestampAtNode[neighbour]);
            if (currentTimestamp < timestampAtNode[neighbour]) result.add(Arrays.asList(currentNode, neighbour));
        }

    }
}
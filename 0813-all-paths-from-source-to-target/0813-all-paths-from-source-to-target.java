class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();

        dfs(graph, new ArrayList<>(), 0, graph.length - 1);

        return result;
        
    }

    void dfs(int[][] graph, List<Integer> currentPath, int currentNode, int finalNode) {
        currentPath.add(currentNode);
        
        if (currentNode == finalNode) {
            result.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }


        for (int nextNode : graph[currentNode]) {
            dfs(graph, currentPath, nextNode, finalNode);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> connectedComponents = new HashMap<>();

        for (int[] edge : edges) {
            connectedComponents.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            connectedComponents.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        int result = 0;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++ ) {
            if (!visited.contains(i)) {
                List<Integer> currentComponents = new ArrayList<>();

                getTotalConnectedComponents(i, connectedComponents, visited, currentComponents);
                int total = currentComponents.size();
                boolean allConnected = true;

                for (int component : currentComponents) {
                    if (!(connectedComponents.getOrDefault(component, new ArrayList<>()).size() == total-1)) {
                        allConnected = false;
                    }
                }

                if (allConnected) {
                    result++;
                }

            }
        }

        return result;
    }

    void getTotalConnectedComponents(int currentEdge, Map<Integer, List<Integer>> connectedComponents, Set<Integer> visited, List<Integer> currentComponents) {
        if (visited.contains(currentEdge)) {
            return;
        }

        visited.add(currentEdge);
        currentComponents.add(currentEdge);

        for (int next : connectedComponents.getOrDefault(currentEdge, new ArrayList<>())) {
            getTotalConnectedComponents(next, connectedComponents, visited, currentComponents);
        }
    }
}
class Solution {
    Map<Integer, List<Integer>> treeConnections;
    Set<Integer> visited;
    Map<Integer, Integer> bobTraversal;
    int result;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        treeConnections = new HashMap<>();
        visited = new HashSet<>();
        bobTraversal = new HashMap<>();
        result = Integer.MIN_VALUE;

        populateTreeConnections(edges);
        Map<Integer, Integer> currentTraversal = new HashMap<>();
        currentTraversal.put(bob, 0);
        findBobAZero(bob, currentTraversal, 1);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        aliceDfs(0, 1, visited, amount[0], amount);

        return result;

    }

    void populateTreeConnections(int[][] edges) {
        for (int[] edge : edges) {
            treeConnections.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            treeConnections.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }

    boolean findBobAZero(int current, Map<Integer, Integer> currentTraversal, int iteration) {
        if (current == 0) {
            bobTraversal = currentTraversal;
            return true;
        }

        List<Integer> connections = treeConnections.get(current);

        for (int i : connections) {
            if (currentTraversal.containsKey(i)) {
                continue;
            }
            currentTraversal.put(i, iteration);
            if (findBobAZero(i, currentTraversal, iteration + 1)) {
                return true;
            }
            currentTraversal.remove(i);
        }

        return false;
    }

    void aliceDfs(int current, int iteration, Set<Integer> visited, int total, int[] amount) {
        boolean found = false;

        List<Integer> connections = treeConnections.get(current);

        for (int i : connections) {
            if (!visited.contains(i)) {
                found = true;
                visited.add(i);
                
                // update total
                int currentAmount = amount[i];
                if (bobTraversal.containsKey(i)) {
                    int bobValue = bobTraversal.get(i);
                    if (iteration > bobValue) {
                        currentAmount = 0;
                    } else if (iteration == bobValue) {
                        currentAmount /= 2;
                    }
                }

                aliceDfs(i, iteration + 1, visited, total + currentAmount, amount);
                visited.remove(i);
            }
        }

        System.out.println(total + ", " + found);

        if (!found) {
            result = Math.max(result, total);
        }
    }
}
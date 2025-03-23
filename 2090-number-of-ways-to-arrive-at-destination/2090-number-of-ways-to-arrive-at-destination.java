class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++ ) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(new int[] {road[1], road[2]});
            graph.get(road[1]).add(new int[] {road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);

        int[] totalPaths = new int[n];

        shortestTime[0] = 0;
        totalPaths[0] = 1;

        pq.add(new long[] {0, 0});

        while (!pq.isEmpty()) {
            long[] candidate = pq.poll();
            long time = candidate[0];
            int node = (int) candidate[1];

            if (time > shortestTime[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                if (time + neighbor[1] < shortestTime[neighbor[0]]) {
                    shortestTime[neighbor[0]] = time + neighbor[1];
                    totalPaths[neighbor[0]] = totalPaths[node];
                    pq.add(new long[]{shortestTime[neighbor[0]], neighbor[0]});
                }
                else if (time + neighbor[1] == shortestTime[neighbor[0]]) {
                    totalPaths[neighbor[0]] = (totalPaths[neighbor[0]] + totalPaths[node]) % MOD;
                }
            }
        }
        
        return totalPaths[n-1];
    }
}
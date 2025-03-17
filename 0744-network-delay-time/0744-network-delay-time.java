class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> directions = new HashMap<>();

        for (int[] time : times) {
            directions.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, k});

        int result = 0;
        int visitedTotal = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (minTime[current[1]] < current[0]) {
                continue;
            }
            minTime[current[1]] = current[0];
            result = current[0];
            visitedTotal++;

            for (int[] next : directions.getOrDefault(current[1], Collections.emptyList())) {
                int newTime = next[1] + current[0];
                if (minTime[next[0]] > newTime) {
                    minTime[next[0]] = newTime;
                    pq.add(new int[]{newTime, next[0]});
                }
            }
        }

        if (visitedTotal == n) {
            return result;
        }

        return -1;
    }
}

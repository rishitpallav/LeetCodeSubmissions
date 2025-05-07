class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;

        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[n][m];

        // PQ : [time, i, j]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentTime = 0;

        pq.add(new int[]{currentTime,0,0});

        while (!pq.isEmpty()) {
            int[] nextNode = pq.poll();
            if (visited[nextNode[1]][nextNode[2]]) {
                continue;
            }
            visited[nextNode[1]][nextNode[2]] = true;

            if (nextNode[1] == n-1 && nextNode[2] == m-1) {
                return nextNode[0];
            }

            for (int[] d : directions) {
                int i = d[0] + nextNode[1];
                int j = d[1] + nextNode[2];
                if (i >= 0 && i < n && j >= 0 && j < m && !visited[i][j]) {
                    pq.add(new int[]{Math.max(nextNode[0], moveTime[i][j])+1, i, j});
                }
            }
        }

        return -1;
    }
}
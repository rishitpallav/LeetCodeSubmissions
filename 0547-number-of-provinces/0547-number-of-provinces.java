class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] completed = new boolean[n];
        int provinces = 0;

        Queue<Integer> travel = new LinkedList<>();

        for (int i = 0; i < n; i++ ) {
            if (completed[i])
                continue;
            completed[i] = true;
            for (int j = 0; j < n; j++ ) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    travel.add(j);
                }
            }

            while (!travel.isEmpty()) {
                int k = travel.poll();

                if (!completed[k]) {
                    completed[k] = true;
                    for (int j = 0; j < n; j++ ) {
                        if (k==j)
                            continue;
                        if (isConnected[k][j] == 1) {
                            travel.add(j);
                        }
                    }
                }
            }
            provinces++;
        }

        return provinces;
    }
}
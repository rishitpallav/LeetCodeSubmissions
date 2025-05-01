class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        boolean[] isComplete = new boolean[n];
        Queue<Integer> connectedNodes = new LinkedList<>();
        int totalProvinces = 0;

        for (int i = 0; i < n; i++ ) {
            if (isComplete[i]) {
                continue;
            }

            for (int j = 0; j < n; j++ ) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1)
                    connectedNodes.add(j);
            }
            isComplete[i] = true;

            while (!connectedNodes.isEmpty()) {
                int k = connectedNodes.poll();
                if (isComplete[k]) {
                    continue;
                }
                for (int j = 0; j < n; j++ ) {
                    if (k == j) {
                        continue;
                    }
                    if (isConnected[k][j] == 1)
                        connectedNodes.add(j);
                }
                isComplete[k] = true;
            }
            totalProvinces++;
        }

        return totalProvinces;
    }
}
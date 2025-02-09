class Solution {
    public int maximumDetonation(int[][] bombs) {
        // nested loop in bombs 
        Map<Integer, List<Integer>> bombsMap = new HashMap<>();

        for (int i = 0; i < bombs.length; i++ ) {
            List<Integer> indices = new ArrayList<>();
            for (int j = 0; j < bombs.length; j++ ) {
                if (j == i) {
                    continue;
                }
                // check if j is initiated by i
                // find the distance between the 2 points => sqrt(x2 - x1)^2 + (y2 - y1)^2
                // distance between 2 points should be less than or equal to radius
                double distance = Math.sqrt(Math.pow(bombs[j][0] - bombs[i][0], 2) + Math.pow(bombs[j][1] - bombs[i][1], 2));
                if ((double)bombs[i][2] >= distance) {
                    indices.add(j);
                }
            }
            bombsMap.put(i, indices);
        }

        int maxConnectedBombs = 0;

        for (int i = 0; i < bombs.length; i++ ) {
            int totalBombs = getConnectedBombs(i, bombsMap);
            maxConnectedBombs = Math.max(maxConnectedBombs, totalBombs);
        }

        return maxConnectedBombs;
    }

    int getConnectedBombs(int index, Map<Integer, List<Integer>> bombsMap) {
        Queue<Integer> currentElements = new LinkedList<>();
        Set<Integer> encountered = new HashSet<>();

        currentElements.add(index);
        encountered.add(index);

        int result = 0;

        while (!currentElements.isEmpty()) {
            int i = currentElements.poll();
            result++;
            for (int j : bombsMap.get(i)) {
                if (encountered.add(j)) {
                    currentElements.add(j);
                }
            }
        }

        return result;
    }
}
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCounter = new HashMap<>();

        int[] result = new int[queries.length];
        int counter = 0;

        for (int i = 0; i < queries.length; i++ ) {
            if (ballColor.containsKey(queries[i][0])) {
                int previousColor = ballColor.get(queries[i][0]);
                int colorCount = colorCounter.get(previousColor)-1;
                if (colorCount == 0) {
                    colorCounter.remove(previousColor);
                } else {
                    colorCounter.put(previousColor, colorCount);
                }
            }
            ballColor.put(queries[i][0], queries[i][1]);
            colorCounter.put(queries[i][1], colorCounter.getOrDefault(queries[i][1], 0)+1);
            result[i] = colorCounter.size();
        }
        return result;
    }
}
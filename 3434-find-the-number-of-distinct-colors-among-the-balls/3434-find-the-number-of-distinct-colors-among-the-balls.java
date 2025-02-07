class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCounter = new HashMap<>();

        int[] result = new int[queries.length];
        int counter = 0;

        for (int i = 0; i < queries.length; i++ ) {
            if (ballColor.containsKey(queries[i][0])) {
                int previousColor = ballColor.get(queries[i][0]);
                // update the color counter
                // decrement the previous color
                colorCounter.put(previousColor, colorCounter.get(previousColor)-1);
                // update the counter
                if (colorCounter.get(previousColor) == 0) {
                    counter--;
                }
            }
            ballColor.put(queries[i][0], queries[i][1]);
            // update color counter
            colorCounter.put(queries[i][1], colorCounter.getOrDefault(queries[i][1], 0)+1);
            // update the counter
            if (colorCounter.get(queries[i][1]) == 1) {
                counter++;
            }
            result[i] = counter;
        }
        return result;
    }
}
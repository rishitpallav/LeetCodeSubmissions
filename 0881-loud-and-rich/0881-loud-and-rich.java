class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        List<Integer>[] poorMap = new ArrayList[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++ ) {
            poorMap[i] = new ArrayList<>();
        }

        for (int[] rich : richer) {
            poorMap[rich[1]].add(rich[0]);
        }

        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++ ) {
            dfs (i, poorMap, quiet, result);
        }

        return result;
    }

    int dfs (int person, List<Integer>[] poorMap, int[] quiet, int[] result) {

        // Memoization
        if (result[person] != -1) return result[person];

        // Initial case if the rich and loud person not found
        // Also helps if the current person is the best match
        result[person] = person;

        // Iterate through possible candidates that we know are poor
        for (int poor : poorMap[person]) {
            int candidate = dfs (poor, poorMap, quiet, result);
            if (quiet[candidate] < quiet[result[person]]) {
                result[person] = candidate;
            }
        }

        // return the best match out of all possible candidates
        return result[person];
    }
}
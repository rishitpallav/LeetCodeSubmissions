class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++ ) {
            indexMap.put(arr[i], i);
        }

        int result = 0;

        int[][] memo = new int[arr.length][arr.length];

        for (int i = arr.length-1; i > 0; i--) {
            for (int j = i-1; j > -1; j-- ) {
                if (indexMap.containsKey(arr[i] + arr[j])) {
                    memo[j][i] = 1 + memo[i][indexMap.get(arr[i] + arr[j])];
                    result = Math.max(result, memo[j][i]);
                } else {
                    memo[j][i] = 2;
                }
            }
        }

        return result > 2?result:0;
    }
}
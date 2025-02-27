class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++ ) {
            indexMap.put(arr[i], i);
        }

        int result = 0;

        for (int i = 0; i < arr.length -2; i++) {
            for (int j = i+1; j < arr.length - 1; j++ ) {
                int first = i;
                int second = j;
                int third = j+1;
                int current = 2;
                while (indexMap.containsKey(arr[first] + arr[second])) {
                    current++;
                    int temp = indexMap.get(arr[first] + arr[second]);
                    first = second;
                    second = temp;
                }
                if (current > 2)
                    result = Math.max(result, current);
            }
        }

        return result;
    }
}
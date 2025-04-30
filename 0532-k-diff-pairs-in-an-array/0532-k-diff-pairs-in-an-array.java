class Solution {
    public int findPairs(int[] nums, int k) {

        if (k < 0 || nums.length == 0) return 0;

        Map<Integer, Integer> numToIndex = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++ ) {
            numToIndex.put(nums[i], numToIndex.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numToIndex.entrySet() ) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    result++;
                }
            } else {
                if (numToIndex.containsKey(entry.getKey() + k)) {
                    result++;
                }
            }
        }

        return result;
    }
}
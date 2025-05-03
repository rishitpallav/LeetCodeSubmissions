class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();

        int left = 0, middle = 0, result = 0;

        for (int right = 0; right < nums.length; right++ ) {
            numToCount.put(nums[right], numToCount.getOrDefault(nums[right], 0) + 1);
            while (numToCount.size() > k) {
                numToCount.put(nums[middle], numToCount.get(nums[middle]) - 1);
                if (numToCount.get(nums[middle]) == 0) {
                    numToCount.remove(nums[middle]);
                }
                middle++;
                left = middle;
            }

            while (numToCount.get(nums[middle]) > 1) {
                numToCount.put(nums[middle], numToCount.get(nums[middle]) - 1);
                middle++;
            }

            if (numToCount.size() == k) {
                result += middle - left + 1;
            }
        }

        return result;
    }
}
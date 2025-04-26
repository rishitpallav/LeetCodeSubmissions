class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
            Two ways I can think on top of my mind:
            1. Nested for loop - O(n^2)
            2. Hash Map: target - nums[i] - O(n) + hashing complexity
            3. Sorting the entire array: binary search to find target - n*log(n) sort + log(n)
        */

        Map<Integer, Integer> numsToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++ ) {
            if (numsToIndex.containsKey(target - nums[i])) {
                return new int[] {numsToIndex.get(target - nums[i]), i};
            }
            numsToIndex.put(nums[i], i);
        }

        return new int[]{};
    }
}
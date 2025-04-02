class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> allElements = new HashSet<>();

        int result = 0;

        for (int num : nums) {
            allElements.add(num);
        }

        for (int i = 0; i < nums.length; i++ ) {
            if (allElements.contains(nums[i]+diff) && allElements.contains(nums[i]+diff+diff)) {
                result++;
            }
        }

        return result;
    }
}
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> previous = new HashSet<>();
        for (int i = 0; i < nums.length; i++ ) {
            if (!previous.add(nums[i])) return nums[i];
        }

        return -1;
    }
}
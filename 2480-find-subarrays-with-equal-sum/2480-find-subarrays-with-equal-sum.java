class Solution {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> sum = new HashSet<>();

        for(int i = 1; i < nums.length; i++ ) {
            int total = nums[i-1] + nums[i];
            if (!sum.add(total)) {
                return true;
            }
        }

        return false;
    }
}
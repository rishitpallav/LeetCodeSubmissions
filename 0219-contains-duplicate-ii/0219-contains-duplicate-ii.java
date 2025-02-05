class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> previousValues = new HashSet<>();

        for(int i = 0; i <= k; i++ ) {
            if (i == nums.length) {
                return false;
            }
            if (previousValues.contains(nums[i])) {
                return true;
            }
            previousValues.add(nums[i]);
        }

        for (int i = k+1; i < nums.length; i++ ) {
            previousValues.remove(nums[i-1-k]);
            if (previousValues.contains(nums[i])) {
                return true;
            }
            previousValues.add(nums[i]);
        }

        return false;
    }
}
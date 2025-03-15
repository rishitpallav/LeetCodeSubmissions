class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 0;
        int high = nums[0];

        for (int i : nums) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (canRob(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean canRob(int[] nums, int k, int current) {
        for (int i = 0; i < nums.length && k > 0; i++ ) {
            if (nums[i] <= current) {
                k--;
                i++;
            }
        }

        return k == 0;
    }
}
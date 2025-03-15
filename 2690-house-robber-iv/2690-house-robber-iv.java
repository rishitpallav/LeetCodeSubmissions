class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 0;
        int high = nums[0];

        for (int i : nums) {
            high = Math.max(high, i);
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (canRob(nums, k, mid)) {
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
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
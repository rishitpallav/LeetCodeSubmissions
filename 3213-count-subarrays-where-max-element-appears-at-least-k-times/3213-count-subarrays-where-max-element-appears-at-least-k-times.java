class Solution {
    public long countSubarrays(int[] nums, int k) {
        int left = 0, count = 0;
        long result = 0;

        int max = nums[0], n = nums.length;

        for (int i = 0; i < n; i++ ) {
            if (max <= nums[i]) {
                max = nums[i];
            }
        }

        for (int right = 0;right < n; right++ ) {
            if (count < k) {
                if (nums[right] == max) {
                    count++;
                }
            }
            while (count == k) {
                if (nums[left] == max)
                    count--;
                left++;
            }
            result += left;
        }

        return result;
    }
}
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> previousElements = new HashSet<>();
        int left = 0;
        long sum = 0;

        long result = 0;

        for (int right = 0; right < nums.length; right++ ) {

            while (previousElements.contains(nums[right]) || right - left + 1 > k) {
                previousElements.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            previousElements.add(nums[right]);
            sum += nums[right];

            if (previousElements.size() == k) {
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
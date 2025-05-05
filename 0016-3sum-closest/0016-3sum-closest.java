class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n-2; i++ ) {
            int left = i+1, right = n-1;

            while (left < right) {
                int currentSum = nums[left] + nums[right] + nums[i];
                if (minDiff > Math.abs(currentSum - target) ) {
                    minDiff = Math.abs(currentSum - target);
                    result = currentSum;
                }
                if (currentSum == target) return target;
                if (currentSum > target) right--;
                else if (currentSum < target) left++;
            }
        }

        return result;
    }
}
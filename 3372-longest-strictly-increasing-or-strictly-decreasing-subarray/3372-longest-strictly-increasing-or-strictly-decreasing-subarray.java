class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int n = nums.length;
        
        if (n < 2) {
            return n;
        }

        boolean increasing = nums[1] > nums[0];
        int counter = 1;
        int result = 1;

        for (int i = 1; i < n; i++ ) {
            if (increasing) {
                if (nums[i] > nums[i-1])
                    counter++;
                else {
                    result = Math.max(result, counter);
                    counter = (nums[i] == nums[i-1] ? 1:2);
                    increasing = false;
                }
            } else {
                if (nums[i] < nums[i-1]) 
                    counter++;
                else {
                    result = Math.max(result, counter);
                    counter = (nums[i] == nums[i-1] ? 1:2);
                    increasing = true;
                }
            }
        }

        return Math.max(result, counter);
    }
}
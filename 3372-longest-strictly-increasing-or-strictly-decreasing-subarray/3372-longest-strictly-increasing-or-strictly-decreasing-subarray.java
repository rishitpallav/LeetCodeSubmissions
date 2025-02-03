class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int n = nums.length;

        int incCounter = 1;
        int decCounter = 1;
        int result = 1;

        for (int i = 1; i < n; i++ ) {
            if (nums[i] > nums[i-1]) {
                incCounter++;
                decCounter = 1;
                result = Math.max(result, incCounter);
            }
            else if (nums[i] < nums[i-1]) {
                decCounter++;
                incCounter = 1;
                result = Math.max(result, decCounter);
            } else {
                incCounter = 1;
                decCounter = 1;
            }
       }

        return result;
    }
}
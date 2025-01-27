class Solution {
    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int currentPower = nums[0];
        int maxPower = currentPower;
        int result = 1;

        for (int i = 1; i < nums.length-1; i++ ) {
            maxPower = Math.max(maxPower - 1, nums[i]);
            currentPower--;
            if (currentPower == 0) {
                currentPower = maxPower;
                result++;
            }
        }

        return result;
    }
}
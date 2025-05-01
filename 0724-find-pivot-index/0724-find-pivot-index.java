class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int currentSum = 0;

        for (int i = 0; i < nums.length; i++ ) {
            System.out.println(currentSum +", "+ 2 * currentSum + nums[i]);
            if (2 * currentSum + nums[i] == sum) {
                return i;
            }
            currentSum += nums[i];
        }

        return -1;
    }
}
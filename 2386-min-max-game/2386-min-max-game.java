class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length > 1) {
            int[] newNums = new int[nums.length/2];
            int index = 0;
            for (int i = 0; i < nums.length; i+=2) {
                if (index%2 == 0)
                    newNums[index] = Math.min(nums[i], nums[i+1]);
                else
                    newNums[index] = Math.max(nums[i], nums[i+1]);
                index++;
            }
            nums = newNums;
        }

        return nums[0];
    }
}
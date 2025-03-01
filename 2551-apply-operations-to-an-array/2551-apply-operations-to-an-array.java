class Solution {
    public int[] applyOperations(int[] nums) {
        int pointer = 0;

        int i = 0;

        while (i < nums.length - 1 ) {
            if (nums[i] == 0) {
                i++;
            } else if (nums[i] == nums[i+1]) {
                nums[pointer++] = nums[i++]*2;
                i++;
            } else {
                nums[pointer++] = nums[i++];
            }
        }

        if (i < nums.length) {
            if (nums[i] == nums[i-1]) {
                nums[pointer++] = 0;
            } else {
                nums[pointer++] = nums[i];
            }
        }

        for (;pointer < nums.length; pointer++ ) {
            nums[pointer] = 0;
        }

        return nums;
    }
}
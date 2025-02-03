class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return 2;
        }

        int frontPointer = 1;
        int iterPointer = 2;

        while (iterPointer < nums.length) {
            if (nums[iterPointer] != nums[frontPointer] || (nums[iterPointer] == nums[frontPointer] && nums[iterPointer] != nums[frontPointer-1])) {
                frontPointer++;
                nums[frontPointer] = nums[iterPointer];
                iterPointer++;
            } else {
                iterPointer++;
            }
        }

        return frontPointer+1;
    }
}
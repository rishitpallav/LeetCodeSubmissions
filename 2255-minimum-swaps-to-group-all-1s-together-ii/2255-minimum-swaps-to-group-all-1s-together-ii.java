class Solution {
    public int minSwaps(int[] nums) {
        int countOnes = 0;

        for (int i : nums) {
            countOnes += i;
        }

        if (countOnes == 0 || countOnes == nums.length) return 0;

        int countZeros = nums.length - countOnes;
        int least = 0;
        int minWindow = countZeros;

        if (countZeros > countOnes) {
            least = 1;
            minWindow = countOnes;
        }

        int counter = 0;

        for (int i = 0; i < minWindow; i++ ) {
            if (nums[i] == least) counter++;
        }

        int right = minWindow;
        int result = counter;

        for (int i = 0; i < nums.length; i++ ) {
            if (least == nums[i]) {
                counter--;
            }
            if (least == nums[right]) {
                counter++;
            }
            result = Math.max(result, counter);

            right = (right + 1)%nums.length;
        }

        return minWindow - result;
    }
}
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxLength = 0;

        for (int n : nums) {
            if (n == 0){
                maxLength = Math.max(maxLength, counter);
                counter = 0;
            }
            else {
                counter++;
            }
        }

        return Math.max(maxLength, counter);
    }
}
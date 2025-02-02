class Solution {
    public boolean check(int[] nums) {
        boolean pass = false;

        for (int i = 1; i < nums.length+1; i++ ) {
            if (nums[i%nums.length] < nums[i-1]) {
                if (pass) {
                    return false;
                }
                pass = true;
            }
        }

        return true;
    }
}
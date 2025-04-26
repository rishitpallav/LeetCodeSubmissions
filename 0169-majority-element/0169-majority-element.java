class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, res = Integer.MIN_VALUE;

        for (int i : nums) {
            if (res == i) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    res = i;
                    count = 1;
                }
            }
        }

        return res;
    }
}
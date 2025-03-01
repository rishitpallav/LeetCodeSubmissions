class Solution {
    public boolean search(int[] nums, int target) {
        for (int i : nums)
            if (target == i)
                return true;
        return false;
    }
}
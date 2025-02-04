class Solution {
    public boolean circularArrayLoop(int[] nums) {
        Set<Integer> traversed = new HashSet<>();

        for (int i = 0; i < nums.length; i++ ) {
            if (!traversed.contains(i)) {
                Set<Integer> currentTraversal = new HashSet<>();
                if (hasCycle(nums, i, currentTraversal, i, (nums[i]>0))) {
                    return true;
                }
                traversed.addAll(currentTraversal);
            }
        }

        return false;
    }
    
    public boolean hasCycle(int[] nums, int i, Set<Integer> currentTraversal, int start, boolean positive) {
        if (currentTraversal.contains(i)) {
            return true;
        }
        if (nums[i] > 0 != positive) {
            return false;
        }
        if (nums[i]%nums.length == 0) {
            return false;
        }
        currentTraversal.add(i);
        i = ((i + nums[i]) % nums.length + nums.length) % nums.length;
        return hasCycle(nums, i, currentTraversal, start, positive);
    }
}
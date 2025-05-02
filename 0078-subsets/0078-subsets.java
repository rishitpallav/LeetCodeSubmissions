class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, -1, new ArrayList<>(), result);
        return result;
    }

    void dfs (int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        if (index == nums.length) {
            return;
        }

        for (int i = index+1; i < nums.length; i++ ) {
            current.add(nums[i]);
            dfs(nums, i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
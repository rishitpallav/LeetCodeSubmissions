class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        createCombinations(nums, target, new ArrayList<>(), 0, 0);

        return result;
    }

    void createCombinations(int[] nums, int target, List<Integer> current, int currentSum, int index) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++ ) {
            current.add(nums[i]);
            createCombinations (nums, target, current, currentSum + nums[i], i);
            current.remove(current.size() - 1);
        }
    }
}

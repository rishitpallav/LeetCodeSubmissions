class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        createCombinations(nums, target, new ArrayList<>(), 0);

        return result;
    }

    void createCombinations(int[] nums, int target, List<Integer> current, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++ ) {
            current.add(nums[i]);
            createCombinations (nums, target - nums[i], current, i+1);
            current.remove(current.size() - 1);
            while (i < nums.length-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
    }
}

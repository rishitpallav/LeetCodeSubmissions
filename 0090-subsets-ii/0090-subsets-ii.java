class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        createList(nums, 0, new ArrayList<>());

        return result;
    }
    public void createList(int[] nums, int index, List<Integer> current) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        createList(nums, index+1, current);
        current.remove(current.size() - 1);
        while (index < nums.length - 1 && nums[index] == nums[index+1]) {
            index++;
        }
        createList(nums, index+1, current);
    }
}
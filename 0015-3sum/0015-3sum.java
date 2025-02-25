class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> previous = new HashSet<>();

        for (int i = 0; i < nums.length-2; i++ ) {
            int left = i+1;
            int right = nums.length -1;
            int target = -nums[i];
            
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    String s = nums[i]+","+nums[left]+","+nums[right];
                    if (previous.add(s)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                    }
                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}

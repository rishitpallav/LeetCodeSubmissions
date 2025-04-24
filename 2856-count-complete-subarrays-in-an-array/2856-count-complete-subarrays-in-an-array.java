class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int counter = 0;
        int left = 0, right = 0;

        int totalDistinct = 0;

        Set<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            distinct.add(num);
        }

        totalDistinct = distinct.size();

        HashMap<Integer, Integer> distinctCounter = new HashMap<>();

        while (right < nums.length) {
            distinctCounter.put(nums[right], distinctCounter.getOrDefault(nums[right], 0) + 1);
            
            while (distinctCounter.size() == totalDistinct) {
                counter += nums.length - right;
                distinctCounter.put(nums[left], distinctCounter.get(nums[left]) - 1);
                if (distinctCounter.get(nums[left]) == 0) {
                    distinctCounter.remove(nums[left]);
                }
                left++;
            }
            right++;
        }

        return counter;
    }
}
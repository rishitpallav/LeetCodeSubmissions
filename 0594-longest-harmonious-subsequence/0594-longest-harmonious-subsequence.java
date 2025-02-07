class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < nums.length; i++ ) {
            counter.put(nums[i], counter.getOrDefault(nums[i],0)+1);
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (counter.containsKey(entry.getKey()+1)) {
                result = Math.max(result, entry.getValue() + counter.get(entry.getKey()+1));
            }
        }

        return result;
    }
}
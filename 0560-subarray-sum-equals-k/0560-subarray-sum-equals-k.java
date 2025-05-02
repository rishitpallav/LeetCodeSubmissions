class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
            {0:1,1:1,2:1,3:1}
        */
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0, result = 0;

        for (int i = 0; i < nums.length; i++ ) {
            sum += nums[i];
            if (sumToCount.containsKey(sum - k)) {
                result += sumToCount.get(sum - k);
            }
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
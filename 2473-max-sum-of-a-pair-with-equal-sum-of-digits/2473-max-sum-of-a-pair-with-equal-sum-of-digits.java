class Solution {
    public int maximumSum(int[] nums) {
        int result = -1;
        HashMap<Integer, Integer> numSumToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++ ) {
            int sum = sumDigits(nums[i]);
            if (numSumToIndex.containsKey(sum)) {
                int largestInHashMap = nums[numSumToIndex.get(sum)];
                if (largestInHashMap < nums[i]) {
                    numSumToIndex.put(sum, i);
                }
                result = Math.max(result, largestInHashMap + nums[i]);
            } else {
                numSumToIndex.put(sum, i);
            }
        }

        return result;
    }

    public int sumDigits(int num) {
        int result = 0;
        while (num > 0) {
            result += num%10;
            num /= 10;
        }
        return result;
    }
}
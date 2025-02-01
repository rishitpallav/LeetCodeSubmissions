class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> previousTable = new HashMap<>();

        previousTable.put(0, 1);
        int sum = 0;
        int resultCounts = 0;

        for (int n : nums) {
            sum += n;
            resultCounts += previousTable.getOrDefault(sum - k, 0);
            previousTable.put(sum, previousTable.getOrDefault(sum, 0) +1);
        }

        return resultCounts;
    }
}
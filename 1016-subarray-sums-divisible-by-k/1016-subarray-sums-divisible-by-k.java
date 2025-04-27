class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> previousTable = new HashMap<>();
        int sum = 0, result = 0;

        previousTable.put(0, 1);

        for (int i : nums) {
            sum += i;
            int remainderToRemove = (sum%k+k)%k;
            result += previousTable.getOrDefault(remainderToRemove, 0);
            previousTable.put(remainderToRemove, previousTable.getOrDefault(remainderToRemove, 0) + 1);
        }

        return result;
    }
}
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        /*
            [1,0,1,0,1]
            [1,1,2,2,3]
            {
                0 : 1
                1 : 2
                2 : 2
                3 : 1
            }
        */
        Map<Integer, Integer> previousTable = new HashMap<>();
        int sum = 0, result = 0;

        previousTable.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += previousTable.getOrDefault(sum - goal, 0);
            previousTable.put(sum, previousTable.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
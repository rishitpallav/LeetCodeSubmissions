class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer>[] dp = new ArrayList[n];
        int maxIndex = n-1;

        for (int i = n-1; i > -1; i-- ) {
            dp[i] = new ArrayList<>();
            for (int j = i+1; j < n; j++ ) {
                if (nums[j] % nums[i] == 0 && dp[j].size() > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                }
            }
            dp[i].add(0, nums[i]);

            if (dp[i].size() > dp[maxIndex].size()) {
                maxIndex = i;
            }
        }

        return dp[maxIndex];
    }
}
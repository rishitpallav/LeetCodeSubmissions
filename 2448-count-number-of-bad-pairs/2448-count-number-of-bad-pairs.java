class Solution {
    public long countBadPairs(int[] nums) {

        // j - i != nums[j] - nums[i]
        // => j - nums[j] != i - nums[i]

        // bad pairs = total pairs - good pairs
        // good pairs = j - nums[j] == i - nums[i]
        // total pairs = (n * (n-1)) / 2

        HashMap<Integer, Long> goodPairsCounter = new HashMap<>();
        long n = (long) nums.length;

        long totalPairs = (n * (n - 1) / 2);
        long goodPairs = 0;


        for (int i = 0; i < n; i++ ) {
            goodPairsCounter.put(i - nums[i], (goodPairsCounter.getOrDefault(i - nums[i], 0L)+1));
        }

        for (long freq : goodPairsCounter.values()) {
            if (freq > 1) {
                goodPairs = (goodPairs + ((freq * (freq - 1)) / 2));
            }
        }

        return (totalPairs - goodPairs);
    }
}
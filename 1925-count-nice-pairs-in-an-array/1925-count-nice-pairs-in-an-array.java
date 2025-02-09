class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int MOD = 1000000007;

        for (int num : nums ) {
            int difference = num - reverseInteger(num);
            indexMap.put(difference, indexMap.getOrDefault(difference, 0)+1);
        }

        long result = 0;

        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            int size = entry.getValue();
            if (size > 1) {
                result = (result + ((long)size * (size - 1) / 2) % MOD) % MOD;
            }
        }

        return (int) result;
    }

    public int reverseInteger(int n) {
        int result = 0;
        while (n > 0) {
            result = (n%10) + (result * 10);
            n /= 10;
        }

        return result;
    }
}
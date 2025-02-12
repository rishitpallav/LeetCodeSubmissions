class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }

        if (sum%2 != 0) {
            return false;
        }
        
        sum /= 2;

        Set<Integer> cache = new HashSet<>();
        cache.add(0);

        for (int i : nums) {
            Set<Integer> tempCache = new HashSet<>();

            for (int c : cache) {
                int addition = c + i;
                if (addition == sum) {
                    return true;
                }
                tempCache.add(addition);
            }
            cache.addAll(tempCache);
        }

        return false;
    }
}
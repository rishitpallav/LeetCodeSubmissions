class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;

        for (int i : candies) {
            max = Math.max(max, i);
        }
        
        int left = 0;
        int right = max;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (isAllocated(candies, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }

    boolean isAllocated(int[] candies, int current, long k) {
        for (int i : candies) {
            k -= (i/current);
            if (k <= 0) {
                return true;
            }
        }

        return false;
    }
}
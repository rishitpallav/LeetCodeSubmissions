class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;

        for (int i : candies) {
            sum += i;
        }
        
        int left = 1;
        int right = (int) (sum/k);
        if (right == 0) return 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isAllocated(candies, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return (int) left - 1;
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
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];

        for (int i : piles) {
            high = Integer.max(high, i);
        }

        while (low < high) {
            int mid = low + (high - low)/2;
            if (isEats(piles, h, mid)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    boolean isEats(int[] piles, int h, int k) {
        for (int i : piles) {
            h -= (i + k - 1)/k;
        }
        return h >= 0;
    }
}
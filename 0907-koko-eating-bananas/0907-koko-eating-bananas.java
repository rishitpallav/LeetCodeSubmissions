class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;

        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (canComplete(h, piles, mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return right;
    }

    boolean canComplete(int h, int[] piles, int k) {
        for (int pile : piles) {
            h -= (pile + k - 1)/k;
        }

        return h >= 0;
    }
}
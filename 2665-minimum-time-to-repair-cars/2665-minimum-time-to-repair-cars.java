class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0L;
        long high = (long) ranks[0] * cars * cars;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long repaired = 0L;
            for (int rank : ranks) {
                repaired += (long) Math.sqrt(mid/rank);
            }

            if (repaired < cars) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
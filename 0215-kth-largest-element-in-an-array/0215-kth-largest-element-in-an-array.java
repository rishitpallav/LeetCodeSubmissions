class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] counter = new int[max - min + 1];

        for (int num : nums) {
            counter[num - min]++;
        }

        for (int i = counter.length-1; i >= 0; i-- ) {
            k -= counter[i];
            if (k <= 0) return i+min;
        }

        return -1;
    }
}
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.add(new int[]{nums[0], 0});

        int max = nums[0];

        for (int i = 1; i < nums.length; i++ ) {
            while (i - pq.peek()[1] > k) {
                pq.poll();
            }
            pq.add(new int[]{Math.max(pq.peek()[0] + nums[i], nums[i]), i});
            max = Math.max(max, pq.peek()[0]);
        }

        return max;
    }
}
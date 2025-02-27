class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < k; i++ ) {
            pq.add(new int[]{nums[i], i});
        }

        int left = 0;
        int[] result = new int[nums.length - k + 1];
        result[left] = pq.peek()[0];
        
        for (; k < nums.length; k++ ) {
            pq.add(new int[]{nums[k], k});
            while (pq.peek()[1] < left + 1)
                pq.poll();
            result[++left] = pq.peek()[0];
        }

        return result;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int result = Integer.MAX_VALUE;
        long sum = 0;

        // 0th index - sum, 1st index - index in array
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getKey()));

        for (int i = 0; i < nums.length; i++ ) {
            sum += nums[i];

            if (sum >= k) {
                result = Math.min(result, i+1);
                
            }
            while (!pq.isEmpty() && sum - pq.peek().getKey() >= k) {
                result = Math.min(result, i - pq.peek().getValue());
                pq.poll();
            }
            pq.offer(new Pair<>(sum, i));
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}
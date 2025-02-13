class Solution {
    public int minOperations(int[] nums, int k) {
        
        if (nums.length == 1) {
            return 0;
        }
        
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.add((long)i);
        }

        int result = 0;

        while (pq.size() > 1) {
            long lowerN = pq.poll();
            long higherN = pq.poll();
            if (lowerN >= k) {
                return result;
            }
            result++;
            pq.add(lowerN * 2 + higherN);
        }
        return result;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        for (int i = 0; i < nums.length; i++ ) {
            pq.add(new int[]{nums[i], i});
        }

        PriorityQueue<int[]> largeValues = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        for (int i = 0; i < k; i++ ) {
            largeValues.add(pq.poll());
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++ ) {
            result[i] = largeValues.poll()[0];
        }

        return result;
    }
}
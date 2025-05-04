class KthLargest {

    int k;
    PriorityQueue<Integer> maxHeap;

    public KthLargest(int k, int[] nums) {
        maxHeap = new PriorityQueue<>();
        this.k = k;

        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);
        if (maxHeap.size() > k) maxHeap.poll();
        return maxHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
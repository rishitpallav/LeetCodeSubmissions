class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> allNums = new PriorityQueue<>();

        for (int i : nums) {
            allNums.add(i);
        }

        int sum = 0;

        while (k > 0 && allNums.peek() < 0) {
            allNums.add(-allNums.poll());
            k--;
        }

        if (k > 0 && k%2 != 0) {
            allNums.add(-allNums.poll());
        }

        while (!allNums.isEmpty()) {
            sum += allNums.poll();
        }

        return sum;
    }
}
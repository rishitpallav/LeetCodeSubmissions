class Solution {
    public boolean isPossible(int[] nums) {
        // 0th index = last inserted element
        // 1st index = count

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int num : nums) {
            while (!maxHeap.isEmpty() && maxHeap.peek()[0]+1 < num) {
                int[] current = maxHeap.poll();
                if (current[1] < 3) return false;
            }

            if (maxHeap.isEmpty() || maxHeap.peek()[0] == num) {
                maxHeap.add(new int[]{num, 1});
            } else if (maxHeap.peek()[0] + 1 == num) {
                int[] temp = maxHeap.poll();
                maxHeap.add(new int[]{num, temp[1]+1});
            }

        }

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            if (current[1] < 3) return false;
        }

        return true;
    }
}
class Solution {
    public boolean isPossible(int[] nums) {
        // 0th index = last inserted element
        // 1st index = count

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        maxHeap.add(new int[]{nums[0] - 1,0});

        for (int num : nums) {
            List<int[]> previous = new ArrayList<>();
            int[] current = new int[]{10000,0};

            while (!maxHeap.isEmpty() && current[0] >= num) {
                current = maxHeap.poll();
                if (current[0] == num-1) break;
                previous.add(current);
            }

            if (current[0] == num-1) {
                current[0] = num;
                current[1]++;
            } else {
                current = new int[]{num, 1};
            }

            // System.out.println("Previous");
            // for (int[] x : previous)
            //     System.out.println(Arrays.toString(x));
            // System.out.println("Current");
            // System.out.println(Arrays.toString(current));

            maxHeap.add(current);
            for (int[] x : previous) maxHeap.add(x);
            // System.out.println();
        }

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            if (current[1] < 3) return false;
        }

        return true;
    }
}
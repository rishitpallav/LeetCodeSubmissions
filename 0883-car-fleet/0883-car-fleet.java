class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pos = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < position.length; i++ ) {
            pos.add(new int[]{position[i], speed[i]});
        }

        int result = 0;
        double previous = 0;

        while (!pos.isEmpty()) {
            int[] current = pos.poll();
            double currentPos = (double) (target - current[0]) / current[1];
            if (currentPos > previous) {
                result++;
                previous = currentPos;
            }
        }

        return result;
    }
}
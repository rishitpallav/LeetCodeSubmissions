class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] chars = new int[26];

        for (char task : tasks) chars[task - 'A']++;
        for (int i : chars) if (i > 0) pq.add(i);

        Queue<int[]> cooldown = new LinkedList<>();
        int t = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            t++;

            if (!pq.isEmpty()) {
                int current = pq.poll() -1 ;
                if (current > 0) {
                    cooldown.add(new int[]{current, t + n});
                }
            }

            while (!cooldown.isEmpty() && cooldown.peek()[1] == t) {
                pq.add(cooldown.poll()[0]);
            }
        }

        return t;
    }
}
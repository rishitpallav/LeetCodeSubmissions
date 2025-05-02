class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];

        for (char task : tasks) chars[task - 'A']++;
        Arrays.sort(chars);
        
        // Take the largest. -1 because we take one at t = 0
        int chunks = chars[25] - 1;
        // Assuming worst case first
        int totalIdleTime = chunks * n;

        // We already took largest, so start with 24
        for (int i = 24; i > -1; i-- ) {
            // Think of it as filling in the blanks A,_,_,A,_,_A => A,B,_,A,B,_,A,B
            totalIdleTime -= Math.min(chars[i], chunks);
        }

        return tasks.length + Math.max(totalIdleTime, 0);
    }
}
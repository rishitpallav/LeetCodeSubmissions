class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] presumTimes = new int[n+2];
        for (int i = 0; i < n; i++ ) {
            presumTimes[i+1] = presumTimes[i] + (endTime[i] - startTime[i]);
        }
        presumTimes[n+1] = presumTimes[n];

        int[][] times = new int[n+2][2];
        times[0][0] = 0;
        times[0][1] = 0;
        times[n+1][0] = eventTime;
        times[n+1][1] = eventTime;

        for (int i = 1; i < n+1; i++ ) {
            times[i][0] = startTime[i-1];
            times[i][1] = endTime[i-1];
        }

       int max = 0;
        int left = 0;
        int right = k+1;

        while (right < n+2) {
            max = Math.max(max, (times[right][0] - times[left][1]) - (presumTimes[right-1] - presumTimes[left]));
            left++;
            right++;
        }

        return max;
    }
}
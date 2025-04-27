class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        int left = 0, maxVal = intervals[0][1];

        for (int i = 1; i < intervals.length; i++ ) {
            if (intervals[i][0] <= maxVal) {
                maxVal = Math.max(maxVal, intervals[i][1]);
                continue;
            }
            result.add(new int[]{intervals[left][0], maxVal});
            left = i;
            maxVal = intervals[i][1];
        }

        result.add(new int[]{intervals[left][0], maxVal});

        int[][] arrayResult = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++ ) {
            arrayResult[i] = result.get(i);
        }

        return arrayResult;
    }
}
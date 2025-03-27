class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Distance that can be travelled with cost and fuel
        int totalDistance = 0;
        // If the current total with cost and fuel is less than 0, we can't proceed further
        int currentTotal = 0;
        int resultIndex = 0;

        for (int i = 0; i < cost.length; i++ ) {
            totalDistance += gas[i] - cost[i];
            currentTotal += gas[i] - cost[i];

            if (currentTotal < 0) {
                resultIndex = i+1;
                currentTotal = 0;
            }
        }

        return (totalDistance >= 0) ? resultIndex : -1;
    }
}
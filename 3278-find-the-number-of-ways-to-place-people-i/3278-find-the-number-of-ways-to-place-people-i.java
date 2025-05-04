class Solution {
    public int numberOfPairs(int[][] points) {
        int counter = 0;
        for (int[] point : points) {
            for (int[] comparePoint : points) {
                if (point[0] <= comparePoint[0] && point[1] >= comparePoint[1] && point != comparePoint) {
                    if (!isInside(point, comparePoint, points)) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    boolean isInside(int[] leftPoint, int[] rightPoint, int[][] points) {
        
        for (int[] checkPoint : points) {
            if (leftPoint == checkPoint || rightPoint == checkPoint) continue;
            if (!(checkPoint[0] < leftPoint[0] ||
                checkPoint[0] > rightPoint[0] ||
                checkPoint[1] < rightPoint[1] ||
                checkPoint[1] > leftPoint[1]
            )) return true;
        }
        return false;
    }
}
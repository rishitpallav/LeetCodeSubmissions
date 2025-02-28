class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pos = new int[position.length][2];

        for (int i = 0; i < position.length; i++ ) {
            pos[i][0] = position[i];
            pos[i][1] = speed[i];
        }

        Arrays.sort(pos, (a, b) -> Integer.compare(b[0], a[0]));

        int result = 1;
        double previous = (double) (target - pos[0][0]) / pos[0][1];

        for (int i = 1; i < position.length; i++ ) {
            double currentPos = (double) (target - pos[i][0]) / pos[i][1];
            if (currentPos > previous) {
                result++;
                previous = currentPos;
            }
        }

        return result;
    }
}
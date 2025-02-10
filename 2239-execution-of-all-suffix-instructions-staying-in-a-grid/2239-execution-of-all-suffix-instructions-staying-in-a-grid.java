class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];

        for (int i = 0 ; i < s.length(); i++ ) {
            int x = startPos[0];
            int y = startPos[1];

            for (int j = i; j < s.length(); j++ ) {
                char instruction = s.charAt(j);
                if (instruction == 'L') {
                    y--;
                } else if (instruction == 'R') {
                    y++;
                } else if (instruction == 'U') {
                    x--;
                } else {
                    x++;
                }
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    result[i]++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
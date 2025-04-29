class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, direction = 0;

        for (int i = 0; i < 4; i++ ) {

            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    if (direction == 0) {
                        y++;
                    } else if (direction == 1) {
                        x++;
                    } else if (direction == 2) {
                        y--;
                    } else {
                        x--;
                    }
                } else {
                    if (c == 'R') {
                        direction = (direction + 1)%4;
                    } else {
                        direction--;
                        if (direction < 0) {
                            direction = 3;
                        }
                    }
                }
            }

            if (x == 0 && y == 0 && direction == 0) {
                return true;
            }
        }
        return false;
    }
}
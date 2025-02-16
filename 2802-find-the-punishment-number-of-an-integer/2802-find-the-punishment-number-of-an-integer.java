class Solution {
    public int punishmentNumber(int n) {
        int total = 0;

        for (int i = 1; i <= n; i++ ) {
            if (matches(0, i, 0, Integer.toString(i*i))) {
                total += i*i;
            }
        }

        return total;
    }

    boolean matches(int i, int target, int currentTotal, String currentString) {
        if (i == currentString.length()) {
            if (target == currentTotal) {
                return true;
            }
            return false;
        }

        for (int j = i; j < currentString.length(); j++ ) {
            if (matches(j+1, target, currentTotal + Integer.parseInt(currentString.substring(i,j+1)), currentString)) {
                return true;
            }
        }

        return false;
    }
}
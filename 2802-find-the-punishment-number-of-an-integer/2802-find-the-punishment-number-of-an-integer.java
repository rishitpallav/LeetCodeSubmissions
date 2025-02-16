class Solution {
    public int punishmentNumber(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (matches(0, i, 0, Integer.toString(i * i))) {
                total += i * i;
            }
        }
        return total;
    }

    boolean matches(int index, int target, int currentTotal, String currentString) {
        if (index == currentString.length()) {
            return currentTotal == target;
        }
        for (int j = index; j < currentString.length(); j++) {
            int partVal = Integer.parseInt(currentString.substring(index, j + 1));
            if (matches(j + 1, target, currentTotal + partVal, currentString)) {
                return true;
            }
        }
        return false;
    }
}

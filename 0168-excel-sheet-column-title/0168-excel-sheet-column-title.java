class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Since excel column number A starts with 1, not 0
            columnNumber--;
            result.append((char)((columnNumber%26) + 'A'));
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}
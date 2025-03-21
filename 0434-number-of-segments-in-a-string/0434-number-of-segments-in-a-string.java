class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean wordFound = false;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (wordFound) {
                    count++;
                    wordFound = false;
                }
            }
            else wordFound = true;
        }

        return (wordFound) ? count + 1 : count;
    }
}
class Solution {
    public boolean checkOnesSegment(String s) {

        boolean foundGroup = false;

        for (int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '1') {
                if (foundGroup) {
                    if (i > 0 && s.charAt(i-1) == '0') {
                        return false;
                    }
                } else
                    foundGroup = true;
            }
        }

        return true;
    }
}
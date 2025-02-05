class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int firstPointer = -1;
        int secondPointer = -1;

        for (int i = 0; i < s1.length(); i++ ) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstPointer == -1)
                    firstPointer = i;
                else if (secondPointer == -1)
                    secondPointer = i;
                else
                    return false;
            }
        }
        if (firstPointer == -1)
            return true;
        if (secondPointer == -1)
            return false;
        return s1.charAt(firstPointer) == s2.charAt(secondPointer) && s1.charAt(secondPointer) == s2.charAt(firstPointer);
    }
}
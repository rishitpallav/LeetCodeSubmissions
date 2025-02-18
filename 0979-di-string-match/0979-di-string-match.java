class Solution {
    public int[] diStringMatch(String s) {
        int l = 0;
        int h = s.length();
        int[] result = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++ ) {
            result[i] = (s.charAt(i)=='I')?l++:h--;
        }
        result[result.length-1] = l;
        
        return result;
    }
}
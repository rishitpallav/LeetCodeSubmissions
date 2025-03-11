class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0;
        int left = 0;
        int combos = 0;
        int n = s.length();

        for (int i = 0; i < n; i++ ) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else {
                c++;
            }

            while (a > 0 && b > 0 && c > 0) {
                combos += (n - i);
                if (s.charAt(left) == 'a') {
                    a--;
                } else if (s.charAt(left) == 'b') {
                    b--;
                } else {
                    c--;
                }
                left++;
            }
        }

        return combos;
    }
}
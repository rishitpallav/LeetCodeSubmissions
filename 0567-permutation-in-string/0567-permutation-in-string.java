class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1chars = new int[26];

        for (char a : s1.toCharArray()) {
            s1chars[a - 'a']++;
        }

        int i = 0;
        int[] s2chars = new int[26];

        for (; i < s1.length(); i++ ) {
            s2chars[s2.charAt(i) - 'a']++;
        }

        if (isEqual(s1chars, s2chars)) {
            return true;
        }

        int left = 0, right = s1.length();

        while (right < s2.length()) {
            s2chars[s2.charAt(left)-'a']--;
            s2chars[s2.charAt(right)-'a']++;
            left++;
            right++;
            if (isEqual(s1chars, s2chars)) {
                return true;
            }
        }

        return false;

    }

    boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++ ) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}

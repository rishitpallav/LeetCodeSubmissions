class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        if (p.length() > s.length()) return new ArrayList<>();

        int[] pCounter = new int[26];

        int[] windowCounter = new int[26];
        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()) {
            pCounter[c-'a']++;
        }

        // count all elements in the size of length p
        for (int i = 0; i < p.length(); i++ ) {
            char c = s.charAt(i);
            windowCounter[c - 'a']++;
        }

        if (Arrays.equals(windowCounter, pCounter)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++ ) {
            char c = s.charAt(i);

            windowCounter[c - 'a']++;
            windowCounter[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(windowCounter, pCounter)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
class Solution {
        public String findValidPair(String s) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            frequency.put(digit, frequency.getOrDefault(digit, 0) + 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i + 1) - '0';
            
            if (d1 != d2 && frequency.get(d1) == d1 && frequency.get(d2) == d2) {
                return "" + d1 + d2;
            }
        }

        return "";
    }
}
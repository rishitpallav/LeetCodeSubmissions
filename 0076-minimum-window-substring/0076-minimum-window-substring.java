class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        int have = 0;
        int need = 0;

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
            if (tMap.get(c) == 1) {
                need++;
            }
        }

        char[] sArr = s.toCharArray();
        int left = 0;
        int right = 0;

        int[] minLength = new int[]{-1, -1};

        while (right < sArr.length) {
            if (tMap.containsKey(sArr[right])) {
                sMap.put(sArr[right], sMap.getOrDefault(sArr[right], 0)+1);
                if (sMap.get(sArr[right]).equals(tMap.get(sArr[right]))) {
                    have++;
                }
            }
            right++;

            while (have == need) {
                
                if (minLength[1] - minLength[0] > right - left || minLength[0] == -1) {
                    minLength[0] = left;
                    minLength[1] = right;
                }

                if (tMap.containsKey(sArr[left])) {
                    if (sMap.get(sArr[left]).equals(tMap.get(sArr[left]))) {
                        have--;
                    }
                    sMap.put(sArr[left], sMap.get(sArr[left])-1);
                }
                left++;
            }
        }
        return minLength[0] == -1?"":s.substring(minLength[0], minLength[1]);
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultHashMap = new HashMap<>();

        for (String s : strs) {
            int[] elements = new int[26];
            for (char c : s.toCharArray()) {
                elements[c - 'a']++;
            }
            resultHashMap.computeIfAbsent(Arrays.toString(elements), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(resultHashMap.values());
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> resultHashMap = new HashMap<>();

        for (String s : strs) {
            int[] elements = new int[26];

            for (char c : s.toCharArray()) {
                elements[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : elements) {
                sb.append(i).append(",");
            }

            resultHashMap.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
        }

        for (Map.Entry<String, List<String>> entry : resultHashMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
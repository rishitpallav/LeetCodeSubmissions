class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int[] lastIndex = new int[26];
        
        for (int i = 0; i < s.length(); i++ ) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int startIndex = 0, farIndex = 0;
        for (int i = 0; i < s.length(); i++ ) {
            if (farIndex < i) {
                result.add(farIndex - startIndex + 1);
                startIndex = i;
                farIndex = i;
            }
            farIndex = Math.max(farIndex, lastIndex[s.charAt(i) - 'a']);
        }

        result.add(s.length() - startIndex);

        return result;
    }
}
class Solution {
    
    Set<String> previous;
    int result;

    public int maxUniqueSplit(String s) {
        previous = new HashSet<>();
        result = 0;

        backtrack(s, 0);

        return result;
    }

    void backtrack(String s, int index) {
        if (index >= s.length()) {
            result = Math.max(result, previous.size());
            return;
        }

        if (s.length() - index + previous.size() <= result) return;

        StringBuilder sb = new StringBuilder();

        for (int i = index; i < s.length(); i++ ) {
            sb.append(s.charAt(i));
            String sub = sb.toString();
            if (!previous.contains(sub)) {
                previous.add(sub);
                backtrack(s, i+1);
                previous.remove(sub);
            }
        }
    }
}
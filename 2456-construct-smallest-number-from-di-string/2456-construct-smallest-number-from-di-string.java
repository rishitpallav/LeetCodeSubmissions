class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++ ) {
            s.push(i+1);

            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!s.empty()) {
                    result.append(s.pop());
                }
            }
        }

        return result.toString();
    }
}

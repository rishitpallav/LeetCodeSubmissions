class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> values = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!values.isEmpty() && values.peek() == c) {
                values.pop();
            } else {
                values.add(c);
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : values) {
            result.append(c);
        }

        return result.toString();
    }
}
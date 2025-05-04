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

        while (!values.isEmpty()) {
            result.append(values.pop());
        }

        return result.reverse().toString();
    }
}
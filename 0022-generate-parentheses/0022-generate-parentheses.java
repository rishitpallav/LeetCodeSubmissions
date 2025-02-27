class Solution {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        backtrack("", n, 0, 0);

        return result;
    }

    void backtrack(String s, int n, int open, int close) {
        if (s.length() == n*2) {
            if (checkValid(s)) {
                result.add(s);
            }
        }
        if (close > open) {
            return;
        }
        if (open < n) {
            backtrack(s + "(", n, open+1, close);
        }
        if (close < n) {
            backtrack(s + ")", n, open, close + 1);
        }
    }

    boolean checkValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!st.empty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push('(');
            }
        }

        return st.empty();
    }
}

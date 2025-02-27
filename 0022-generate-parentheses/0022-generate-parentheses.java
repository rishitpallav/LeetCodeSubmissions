class Solution {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        backtrack("", n, 0, 0);

        return result;
    }

    void backtrack(String s, int n, int open, int close) {
        if (s.length() == n*2) {
            result.add(s);
            return;
        }
        if (open < n) {
            backtrack(s + "(", n, open+1, close);
        }
        if (close < open) {
            backtrack(s + ")", n, open, close + 1);
        }
    }
}

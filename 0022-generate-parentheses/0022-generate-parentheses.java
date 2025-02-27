class Solution {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        backtrack("(", n-1, n);

        return result;
    }

    void backtrack(String s, int open, int close) {
        if(open > 0){
            backtrack(s + "(", open - 1, close);
        }
        if(close > 0 && open < close){
            backtrack(s + ")", open, close - 1);
        }
        if(open == 0 && close == 0){
            result.add(s);
        }
    }
}

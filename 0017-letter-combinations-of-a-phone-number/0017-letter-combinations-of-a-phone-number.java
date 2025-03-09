class Solution {
    
    char[][] dailer = new char[][]{
        {},{},
        {'a','b','c'},
        {'d','e','f'},
        {'g','h','i'},
        {'j','k','l'},
        {'m','n','o'},
        {'p','q','r','s'},
        {'t','u','v'},
        {'w','x','y','z'}};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        combos(digits, 0, new StringBuilder(), result);

        return result;
    }

    void combos(String digits, int index, StringBuilder current, List<String> result) {
        if (current.length() == digits.length()) {
            if (current.length() > 0)
                result.add(current.toString());
            return;
        }

        int number = (int) digits.charAt(index) - '0';

        for (char c : dailer[number]) {
            current.append(Character.toString(c));
            combos(digits, index+1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

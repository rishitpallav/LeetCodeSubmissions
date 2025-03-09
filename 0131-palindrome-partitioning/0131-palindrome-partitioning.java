class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        createPalindromes(s, 0, 0, new ArrayList<>());

        return result;
    }

    void createPalindromes(String s, int start, int index, List<String> current) {
        if (index >= s.length()) {
            if (index == start) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if (isPalindrome(s, start, index)) {
            current.add(s.substring(start, index+1));
            createPalindromes(s, index+1, index+1, current);
            current.remove(current.size() - 1);
        }
        createPalindromes(s, start, index+1, current);
    }

    boolean isPalindrome(String s, int firstPointer, int lastPointer) {
        while (firstPointer < lastPointer) {
            if (s.charAt(firstPointer) != s.charAt(lastPointer)) {
                return false;
            }
            firstPointer++;
            lastPointer--;
        }

        return true;
    }
}

class Solution {
    public String lastSubstring(String s) {

        /*

            I don't like this problem and I'm only solving this for the sake of Goldman Sachs Interview Prep
            Which I don't think I can pass. Anyway.

            Intuition:
            Identify the characters that have highest ord() from the string and
            then compare which one has the longest lexicographical order.

            The issue with straight up implementing this approach is it takes O(n^2)
            to compare all the strings that have the same starting character.
            You can look at my previous failed submissions for this problem to that implementation.

            Efficient Approach:
            The problem itself is a 3 pointer approach suffix array type of problem.
            leftPointer is assumed to be the max character ord()
            rightPointer helps us track if there is another max ord() character going forward.
            k helps us expand the search.
            
        */


        int left = 0, right = 1, k = 0;

        while (right + k < s.length()) {
            if (s.charAt(left+k) == s.charAt(right+k)) {
                // Both characters are same, expand k
                k++;
            } else if (s.charAt(left+k) < s.charAt(right+k)) {
                // We found a character at right which has higher ord() than left
                left = Math.max(left + k + 1, right);
                right = left + 1;
                k = 0;
            } else {
                // Our left pointer is higher, push right pointer to farthest
                right = right + k + 1;
                k = 0;
            }
        }


        return s.substring(left);
    }
}
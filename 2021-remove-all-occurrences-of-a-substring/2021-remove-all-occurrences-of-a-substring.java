class Solution {
    public String removeOccurrences(String s, String part) {
        int partLength = part.length();

        if (partLength > s.length()) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++ ) {
            result.append(s.charAt(i));
            if (result.length() >= partLength) {
                if (result.substring(result.length() - partLength, result.length()).equals(part)) {
                    result.setLength(result.length() - partLength);
                }
            }
        }

        return result.toString();
    }
}
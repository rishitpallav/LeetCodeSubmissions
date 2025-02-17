class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String d : dictionary) {
            int firstPointer = 0;
            for (int i = 0; i < s.length(); i++ ) {
                if (s.charAt(i) == d.charAt(firstPointer)) {
                    firstPointer++;
                    if (firstPointer == d.length()) {
                        if (result.length() < d.length()) {
                            result = d;
                        } else if ((result.length() == d.length()) && (result.compareTo(d) > 0)) {
                            result = d;
                        }
                        break;
                    }
                }
            }
        }

        return result;
    }
}
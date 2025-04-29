class Solution {
    public int compress(char[] chars) {
        int insertPointer = 0, counter = 0;
        char previousChar = chars[0];

        for (int i = 0; i < chars.length; i++ ) {
            if (previousChar == chars[i]) {
                counter++;
            } else {
                chars[insertPointer++] = previousChar;
                if (counter > 1) {
                    String c = counter + "";
                    for (int j = 0; j < c.length(); j++ ) {
                        chars[insertPointer++] = c.charAt(j);
                    }
                }
                previousChar = chars[i];
                counter = 1;
            }
        }

        if (counter >= 1) {
            chars[insertPointer++] = previousChar;
            if (counter > 1) {
                String c = counter + "";
                for (int j = 0; j < c.length(); j++ ) {
                    chars[insertPointer++] = c.charAt(j);
                }
            }
        }

        return insertPointer;
    }
}
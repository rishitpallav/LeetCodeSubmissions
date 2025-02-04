class Solution {
    public int compress(char[] chars) {
        
        int count = 0;
        int pointer = 0;
        char currentChar = chars[0];

        for (int i = 0; i < chars.length; i++ ) {
            if (currentChar == chars[i]) {
                count++;
            } else {
                if (count == 1) {
                    chars[pointer] = currentChar;
                    pointer++;
                } else {
                    chars[pointer] = currentChar;
                    pointer++;
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[pointer] = c;
                        pointer++;
                    }
                }
                currentChar = chars[i];
                count = 1;
            }
        }

        if (count == 1) {
            chars[pointer] = currentChar;
            pointer++;
        } else {
            chars[pointer] = currentChar;
            pointer++;
            for (char c : String.valueOf(count).toCharArray()) {
                chars[pointer] = c;
                pointer++;
            }
        }

        return pointer;
    }
}
class Solution {
    int pointer = 0;
    public String decodeString(String s) {
        return forwardDecode(s).toString();
    }

    public StringBuilder forwardDecode(String s) {

        StringBuilder main = new StringBuilder();

        while (pointer < s.length() && s.charAt(pointer) != ']') {

            char c = s.charAt(pointer);
            if (Character.isDigit(c)) {

                StringBuilder sb = new StringBuilder();

                int number = 0;
                while (Character.isDigit(s.charAt(pointer))) {
                    number = (number*10) + s.charAt(pointer++) - '0';
                }

                pointer++;

                sb = forwardDecode(s);

                pointer++;

                while (number-- > 0) {
                    main.append(sb);
                }
            } else {
                main.append(c);
                pointer++;
            }

        }

        return main;

    }
}
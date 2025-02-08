class Solution {
    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();

        int n = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++ ) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                n = (n*10) + (current - '0');
            }
            
            if ((!Character.isDigit(current) && current != ' ') || i == s.length() - 1 ) {
                if (operator == '+') {
                    numbers.push(n);
                } else if (operator == '-') {
                    numbers.push(-n);
                } else if (operator == '*') {
                    numbers.push(numbers.pop() * n);
                } else {
                    numbers.push(numbers.pop() / n);
                }

                operator = current;
                n = 0;
            }
        }

        while (!numbers.isEmpty()) {
            n += numbers.pop();
        }

        return n;
    }
}
class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int total = 0;
        int num = 0;
        int sign = 1;
        int counter = 0;

        for (int i = 0; i < s.length(); i++ ) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num = (num * 10) + (current - '0');
            }
            else if (current == '+') {
                total += (num * sign);
                num = 0;
                sign = 1;
            } else if (current == '-') {
                total += (num * sign);
                num = 0;
                sign = -1;
            } else if (current == '(') {
                stack.push(total);
                stack.push(sign);
                total = 0;
                sign = 1;
            } else if (current == ')') {
                total += sign * num;
                num = 0;
                total = total * stack.pop();
                total += stack.pop();
            }
        }

        total += (num * sign);

        return total;
    }
}
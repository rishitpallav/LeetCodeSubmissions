class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalidParanthesis = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++ ) {
            if (Character.isAlphabetic(s.charAt(i))) {
                continue;
            }
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    invalidParanthesis.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            invalidParanthesis.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++ ) {
            if (!invalidParanthesis.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (c.equals("-")) {
                int f = st.pop();
                int s = st.pop();
                st.push(s - f);
            } else if (c.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (c.equals("/")) {
                int f = st.pop();
                int s = st.pop();
                st.push(s / f);
            } else {
                st.push(Integer.parseInt(c));
            }
        }

        return st.peek();
    }
}
class MinStack {

    Stack<Integer> mono;
    Stack<Integer> st;

    public MinStack() {
        mono = new Stack<>();
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (mono.empty() || val <= mono.peek()) {
            mono.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        int val = st.pop();
        if (val == mono.peek()) {
            mono.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return mono.peek();
    }
}
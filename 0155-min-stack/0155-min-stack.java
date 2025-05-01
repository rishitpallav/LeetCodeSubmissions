class MinStack {

    Map<Integer, Integer> valueCounts;
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;

    public MinStack() {
        valueCounts = new HashMap<>();
        stack = new Stack<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.push(val);
        pq.add(val);
        valueCounts.put(val, valueCounts.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int val = stack.pop();
        valueCounts.put(val, valueCounts.get(val) - 1);
        if (valueCounts.get(val) == 0) {
            valueCounts.remove(val);
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int lowest = pq.peek();
        while (!valueCounts.containsKey(lowest)) {
            pq.poll();
            lowest = pq.peek();
        }

        return lowest;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
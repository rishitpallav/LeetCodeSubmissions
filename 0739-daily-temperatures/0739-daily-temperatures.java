class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int n  = temperatures.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++ ) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int temp = stack.pop();
                result[temp] = i - temp;
            }
            stack.push(i);
        }

        return result;
    }
}
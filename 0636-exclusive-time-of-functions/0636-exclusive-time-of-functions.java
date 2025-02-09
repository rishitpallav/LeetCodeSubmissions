class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] totalTime = new int[n];

        Stack<Integer> callStack = new Stack<>();

        String[] x = logs.get(0).split(":");
        int previousTime = Integer.parseInt(x[2]);

        for (String s : logs) {
            String[] log = s.split(":");
            if (log[1].charAt(0) == 's') {
                if (!callStack.isEmpty()) {
                    totalTime[callStack.peek()] += Integer.parseInt(log[2]) - previousTime;
                }
                callStack.push(Integer.parseInt(log[0]));
                previousTime = Integer.parseInt(log[2]);
            } else {
                totalTime[callStack.peek()] += Integer.parseInt(log[2]) - previousTime + 1;
                callStack.pop();
                previousTime = Integer.parseInt(log[2]) + 1;
            }
        }

        return totalTime;
    }
}
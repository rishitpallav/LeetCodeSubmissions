class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] totalTime = new int[n];

        Stack<Integer> callStack = new Stack<>();

        String[] x = logs.get(0).split(":");
        int previousTime = Integer.parseInt(x[2]);

        for (String s : logs) {
            String[] log = s.split(":");
            int timestamp = Integer.parseInt(log[2]);
            if (log[1].charAt(0) == 's') {
                if (!callStack.isEmpty()) {
                    totalTime[callStack.peek()] += timestamp - previousTime;
                }
                callStack.push(Integer.parseInt(log[0]));
            } else {
                totalTime[callStack.peek()] += timestamp - previousTime + 1;
                callStack.pop();
                // Because we need to compare previousTime from the next, ignoring this timeblock. This timeblock is used.
                timestamp++;
            }
            previousTime = timestamp;
        }

        return totalTime;
    }
}
class Solution {

    class Pair {
        char c;
        int count;

        Pair (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> tracker = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!tracker.isEmpty() && tracker.peek().c == c) {
                int totalCount = tracker.peek().count;
                if (totalCount == k-1) {
                    for (int i = 0; i < k-1; i++ ) {
                        tracker.pop();
                    }
                } else {
                    tracker.add(new Pair(c, totalCount+1));
                }
            } else {
                tracker.add(new Pair(c, 1));
            }
        }

        StringBuilder result = new StringBuilder();

        for (Pair pair : tracker) {
            result.append(pair.c);
        }

        return result.toString();
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (groupSize == 1) return true;

        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        HashMap<Integer, List<Integer>> history = new HashMap<>();
        for (int current : hand) {
            if (history.containsKey(current-1)) {
                int previousCount = history.get(current-1).removeFirst();
                if (previousCount != groupSize-1) {
                    history.computeIfAbsent(current, k -> new LinkedList<>()).add(previousCount + 1);
                }
                if (history.get(current-1).isEmpty()) {
                    history.remove(current-1);
                }
            } else {
                history.computeIfAbsent(current, k -> new LinkedList<>()).add(1);
            }
        }

        return history.isEmpty();
    }
}
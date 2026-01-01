class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (k == 1) return true;

        if (nums.length % k != 0) return false;

        Arrays.sort(nums);

        HashMap<Integer, List<Integer>> history = new HashMap<>();
        for (int current : nums) {
            if (history.containsKey(current-1)) {
                int previousCount = history.get(current-1).removeFirst();
                if (previousCount != k-1) {
                    history.computeIfAbsent(current, n -> new LinkedList<>()).add(previousCount + 1);
                }
                if (history.get(current-1).isEmpty()) {
                    history.remove(current-1);
                }
            } else {
                history.computeIfAbsent(current, n -> new LinkedList<>()).add(1);
            }
        }

        return history.isEmpty();
    }
}
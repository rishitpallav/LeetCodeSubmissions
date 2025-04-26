class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        int k = nums.length/2;

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
            if (counter.get(i) > k) return i;
        }

        return -1;
    }
}
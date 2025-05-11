class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List[] bucket = new List[nums.length+1];
        // for (int i = 0; i < nums.length; i++ ) {
        //     bucket[i] = new ArrayList<>();
        // }
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < nums.length; i++ ) {
            counter.put(nums[i], counter.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<Integer>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = nums.length; i >= 0; i-- ) {
            if (bucket[i] == null) continue;
            int j = 0;
            while (j < bucket[i].size() && index < result.length) {
                result[index++] = (int) bucket[i].get(j++);
            }
        }

        return result;
    }
}
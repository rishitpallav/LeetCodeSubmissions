class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> previousElements = new HashMap<>();

        for (int i = 0; i < numbers.length; i++ ) {
            if (previousElements.containsKey(target - numbers[i])) {
                return new int[]{previousElements.get(target-numbers[i])+1, i+1};
            }
            previousElements.put(numbers[i], i);
        }

        return new int[]{-1,-1};
    }
}
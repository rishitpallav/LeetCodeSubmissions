class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> prevProduct = new HashMap<>();

        int result = 0;

        for (int i = 0; i < nums.length - 1; i++ ) {
            for (int j = i+1; j < nums.length; j++ ) {
                int product = nums[i]*nums[j];
                int previousValue = prevProduct.getOrDefault(product, 0);
                result += 8 * previousValue;
                prevProduct.put(product, previousValue+1);
            }
        }

        return result;
    }
}
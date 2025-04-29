class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixProd = new int[n+2];
        int[] suffixProd = new int[n+2];
        int[] result = new int[n];
        prefixProd[0] = 1;
        suffixProd[n+1] = 1;

        for (int i = 1; i <= n; i++ ) {
            prefixProd[i] = prefixProd[i-1] * nums[i-1];
            suffixProd[n-i+1] = suffixProd[n-i+2] * nums[n-i];
        }

        for (int i = 0; i < nums.length; i++ ) {
            result[i] = prefixProd[i] * suffixProd[i+2];
        }

        return result;
    }
}
class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k%n;
        if (k==0) return;
        int rotateKey = n - k;

        int[] result = new int[n];

        for (int i = 0; i < n; i++ ) {
            result[i] = nums[rotateKey++];
            if (rotateKey == n) {
                rotateKey = 0;
            }
        }

        for (int i = 0; i < n; i++ ) {
            nums[i] = result[i];
        }
    }
}
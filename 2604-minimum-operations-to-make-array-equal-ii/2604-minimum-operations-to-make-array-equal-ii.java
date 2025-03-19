class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long result = 0;
        long counter = 0;

        if (k == 0) {
            for (int i = 0; i < nums1.length; i++ ) {
                if (nums1[i] != nums2[i]) return -1;
            }
            return 0;
        }

        for (int i = 0; i < nums1.length; i++ ) {
            int diff = nums1[i] - nums2[i];
            if (diff < 0) {
                diff *= -1;
                if (diff % k != 0) return -1;
                int current = diff / k;
                result += current;
                counter -= current;
            } else {
                if (diff % k != 0) return -1;
                int current = diff / k;
                result += current;
                counter += current;
            }
        }

        if (counter != 0) return -1;

        return result/2;
    }
}
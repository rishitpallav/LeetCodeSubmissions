class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0, right = 0, n = nums1.length, m = nums2.length;
        int counter = (n + m)  / 2;
        int prev = 0, current = 0;

        while (counter >= 0) {
            prev = current;
            if ((left < n) && (right >= m || nums1[left] < nums2[right])) {
                current = nums1[left++];
            } else {
                current = nums2[right++];
            }
            counter--;
        }

        return ((n+m)%2==0) ? (prev + current)/2.0 : current;
    }
}
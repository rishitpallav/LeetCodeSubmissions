class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left = 0, right = 0, n = nums1.length, m = nums2.length;
        boolean isCurrentLeft = true;
        if (left >= n || (right < m && nums1[left] > nums2[right])) {
            isCurrentLeft = false;
        }

        int counter = (n + m)  / 2;
        if ((n + m)%2 == 0) {
            counter--;
        }

        while (counter > 0) {
            if (isCurrentLeft) {
                left++;
            } else {
                right++;
            }
            counter--;
            if (left < n) {
                if (right >= m || nums1[left] < nums2[right]) {
                    isCurrentLeft = true;
                } else {
                    isCurrentLeft = false;
                }
            } else {
                isCurrentLeft = false;
            }
        }

        if ((n+m)%2!=0) {
            return (double) ((isCurrentLeft)?nums1[left]:nums2[right]);
        } else {
            double result = 0.0;
            int smallest = 0;
            int nextSmallest = 0;
            if (isCurrentLeft) {
                smallest = nums1[left];
                left++;
            } else {
                smallest = nums2[right];
                right++;
            }
            if (left < n) {
                if (right >= m || nums1[left] < nums2[right]) {
                    nextSmallest = nums1[left];
                } else {
                    nextSmallest = nums2[right];
                }
            } else {
                nextSmallest = nums2[right];
            }

            return ((double) (smallest + nextSmallest))/2;
        }
    }
}
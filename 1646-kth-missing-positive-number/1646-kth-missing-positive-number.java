class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = right - left / 2;

            int previous = arr[mid] - (mid + 1);

            if (previous >= k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        int previous = arr[left] - (left + 1);

        if (k > previous) {
            return arr[left] + (k - previous);
        }
        return k;
    }
}
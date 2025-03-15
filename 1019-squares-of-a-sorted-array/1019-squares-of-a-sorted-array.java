class Solution {
    public int[] sortedSquares(int[] nums) {
        int rightPartition = findIndex(nums);
        int leftPartition = rightPartition-1;

        int[] result = new int[nums.length];
        int index = 0;

        while (leftPartition > -1 && rightPartition < nums.length) {
            int leftPartitionValue = nums[leftPartition] * nums[leftPartition];
            int rightPartitionValue = nums[rightPartition] * nums[rightPartition];

            if (leftPartitionValue < rightPartitionValue) {
                result[index++] = leftPartitionValue;
                leftPartition--;
            } else {
                result[index++] = rightPartitionValue;
                rightPartition++;
            }
        }

        while (leftPartition > -1) {
            result[index++] = nums[leftPartition] * nums[leftPartition];
            leftPartition--;
        }

        while (rightPartition < nums.length) {
            result[index++] = nums[rightPartition] * nums[rightPartition];
            rightPartition++;
        }

        return result;
    }

    int findIndex (int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right ) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < 0) {
                left = mid + 1;
            } else if (nums[mid] > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
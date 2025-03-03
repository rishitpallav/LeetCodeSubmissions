class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> greaterElements = new ArrayList<>();
        int equalCount = 0;
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                nums[index++] = num;
            } else if (num > pivot) {
                greaterElements.add(num);
            } else {
                equalCount++;
            }
        }

        while (equalCount-- > 0) {
            nums[index++] = pivot;
        }

        for (int i : greaterElements) {
            nums[index++] = i;
        }

        return nums;
    }
}
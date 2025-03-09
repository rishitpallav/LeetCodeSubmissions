class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<int[]> mono = new Stack<>();

        int result = 0;

        for (int i = 0; i < nums.length; i++ ) {
            if (mono.isEmpty() || mono.peek()[0] > nums[i]) {
                mono.push(new int[]{nums[i], i});
            }
        }

        for (int i = nums.length - 1 ; i > -1; i-- ) {
            while (!mono.isEmpty() && mono.peek()[0] <= nums[i]) {
                result = Math.max(result, (i - mono.pop()[1]));
            }
        }

        return result;
    }
}
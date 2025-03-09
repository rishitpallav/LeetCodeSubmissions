class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<int[]> mono = new Stack<>();

        int result = 0;

        for (int i = 0; i < nums.length; i++ ) {
            if (mono.isEmpty() || mono.peek()[0] > nums[i]) {
                mono.push(new int[]{nums[i], i});
            } else {
                Stack<int[]> temp = new Stack<>();

                while (!mono.isEmpty() && mono.peek()[0] <= nums[i]) {
                    result = Math.max(result, i - mono.peek()[1]);
                    temp.push(mono.pop());
                }

                while (!temp.isEmpty()) {
                    mono.push(temp.pop());
                }
            }
        }

        return result;
    }
}
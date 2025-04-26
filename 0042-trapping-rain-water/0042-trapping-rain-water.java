class Solution {
    public int trap(int[] height) {
        // intuition:
        // ele = [0,1,0,2,1,0,1,3,2,1,2,1]
        // left= [0,1,1,2,2,2,2,3,3,3,3,3]
        // right=[3,3,3,3,3,3,3,3,2,2,2,1]
        // total=[0,0,1,0,1,2,1,0,0,1,0,0]

        int n = height.length;
        int[] right = new int[n];
        int result = 0;

        int max = height[n-1];
        for (int i = n-1; i >= 0; i-- ) {
            max = Math.max(height[i], max);
            right[i] = max;
        }

        max = height[0];
        for (int i = 0; i < n; i++ ) {
            max = Math.max(height[i], max);
            result += Math.min(max, right[i]) - height[i];
        }

        return result;
    }
}

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0)
            return result;
        
        int start = 1;
        int end = k;

        if (k < 0) {
            start = n - Math.abs(k);
            end = n - 1;
        }

        for (int i = start; i <= end; i++ ) {
            result[0] += code[i];
        }

        for (int i = 1; i < n; i++ ) {
            end = (end+1)%n;
            result[i] = result[i-1] + code[end] - code[start];
            start = (start+1)%n;
        }


        return result;

    }
}
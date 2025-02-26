class Solution {
    public int numOfSubarrays(int[] arr) {

        int MOD = 1000000007;

        int odd = 0;
        int prevOdd = 0;

        int even = 0;
        int prevEven = 0;

        if (arr[0]%2 == 0) {
            prevEven = 1;
        } else {
            prevOdd = 1;
        }

        int total = prevOdd;

        for (int i = 1; i < arr.length; i++ ) {
            if (arr[i]%2 == 1) {
                odd = (prevEven + 1)%MOD;
                even = prevOdd;
            } else {
                even = (prevEven + 1)%MOD;
                odd = prevOdd;
            }
            prevOdd = odd;
            prevEven = even;
            total = (total + odd)%MOD;
        }

        return total;
    }
}
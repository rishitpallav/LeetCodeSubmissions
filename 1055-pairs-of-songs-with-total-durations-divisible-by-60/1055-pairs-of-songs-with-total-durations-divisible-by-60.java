class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] previousNumbers = new int[60];
        int total = 0;

        for (int t : time) {
            int divisible = t%60;
            
            // Offset 0
            if (divisible != 0) divisible = 60 - divisible;
            
            total += previousNumbers[divisible];
            previousNumbers[t%60] += 1;
        }

        return total;
    }
}
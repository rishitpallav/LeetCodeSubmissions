class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> previousNumbers = new HashMap<>();
        int total = 0;

        for (int t : time) {
            int divisible = t%60;
            if (divisible != 0) divisible = 60 - divisible;
            total += previousNumbers.getOrDefault(divisible, 0);
            previousNumbers.put(t%60, previousNumbers.getOrDefault(t%60,0)+1);
        }

        return total;
    }
}
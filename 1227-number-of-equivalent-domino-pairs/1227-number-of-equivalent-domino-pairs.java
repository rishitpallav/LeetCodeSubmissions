class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] elements = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int hashvalue = d[0]*10 + d[1];
            if (d[1] < d[0]) {
                hashvalue = d[1]*10 + d[0];
            }
            result += elements[hashvalue];
            elements[hashvalue]++;
        }

        return result;
    }
}
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> elements = new HashMap<>();
        int result = 0;

        for (int[] d : dominoes) {
            String hashval = d[0] +","+ d[1];
            if (d[1] < d[0]) {
                hashval = d[1] +","+ d[0];
            }
            result += elements.getOrDefault(hashval, 0);
            elements.put(hashval, elements.getOrDefault(hashval,0)+1);
        }

        return result;
    }
}
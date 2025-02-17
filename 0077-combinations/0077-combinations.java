class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        findPairs(n, k, new ArrayList<>());
        return result;
    }

    void findPairs(int n, int k, List<Integer> current) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = n; i > 0; i-- ) {
            current.add(i);
            findPairs(i-1, k-1, current);
            current.remove(current.size()-1);
        }
    }
}
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> previous = new HashSet<>();
        Set<String> result = new HashSet<>();

        int n = s.length();

        for (int i = 0; i <= n-10; i++ ) {
            String sub = s.substring(i, i+10);
            if (!previous.add(sub)) {
                result.add(sub);
            }
        }

        List<String> res = new ArrayList<>();
        res.addAll(result);

        return res;
    }
}
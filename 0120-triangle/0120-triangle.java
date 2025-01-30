class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>();

        dp.add(new ArrayList<>());
        dp.get(0).add(triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++ ) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++ ) {
                if (j == 0) {
                    dp.get(i).add(j, dp.get(i-1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    dp.get(i).add(j, dp.get(i-1).get(j-1) + triangle.get(i).get(j));
                } else {
                    dp.get(i).add(j, Math.min(dp.get(i-1).get(j), dp.get(i-1).get(j-1)) + triangle.get(i).get(j));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int n = triangle.get(triangle.size()-1).size()-1;

        for (int i = 0 ; i < triangle.get(n).size(); i++ ) {
            min = Math.min(min, dp.get(n).get(i));
        }

        return min;
    }
}
class Solution {
    int[][] increasingMemo;
    int[][] decreasingMemo;
    public int numTeams(int[] rating) {
        increasingMemo = new int[rating.length][4];
        decreasingMemo = new int[rating.length][4];

        for (int[] x : increasingMemo) {
            Arrays.fill(x, -1);
        }
        for (int[] x : decreasingMemo) {
            Arrays.fill(x, -1);
        }

        return dfs(rating, 0, 3, -1, true) + dfs(rating, 0, 3, Integer.MAX_VALUE, false);
    }

    int dfs(int[] rating, int index, int people, int previous, boolean isIncrease) {
        if (people == 0) return 1;
        if (index >= rating.length) return 0;

        if (isIncrease) {
            if (increasingMemo[index][people] != -1) return increasingMemo[index][people];
        } else {
            if (decreasingMemo[index][people] != -1) return decreasingMemo[index][people];
        }

        int counter = 0;

        for (int i = index; i < rating.length; i++ ) {
            if (isIncrease && rating[i] > previous) {
                counter += dfs(rating, i+1, people-1, rating[i], isIncrease);
            } else if (!isIncrease && rating[i] < previous) {
                counter += dfs(rating, i+1, people-1, rating[i], isIncrease);
            }
        }

        if (isIncrease) {
            increasingMemo[index][people] = counter;
        } else {
            decreasingMemo[index][people] = counter;
        }

        return counter;
    }
}
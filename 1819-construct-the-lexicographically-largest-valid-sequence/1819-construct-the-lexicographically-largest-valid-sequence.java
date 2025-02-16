class Solution {
    int[] result;
    public int[] constructDistancedSequence(int n) {
        result = new int[(2*n)-1];
        Set<Integer> used = new HashSet<>();

        constructDistancedSequence(n, used);

        return result;
    }

    boolean constructDistancedSequence(int n, Set<Integer> used) {
        int current = -1;
        for (int i = 0; i < result.length; i++ ) {
            if (result[i] == 0) {
                current = i;
                break;
            }
        }

        if (current == -1) {
            return true;
        }

        for (int i = n; i > 0; i-- ) {
            if (i == 1) {
                if (!used.contains(1)) {
                    used.add(1);
                    result[current] = 1;
                    if(constructDistancedSequence(n, used)) {
                        return true;
                    }
                    result[current] = 0;
                    used.remove(1);
                }
            } else {
                if (!used.contains(i) && current + i < result.length && result[current+i] == 0) {
                    used.add(i);
                    result[current] = i;
                    result[current + i] = i;
                    if (constructDistancedSequence(n, used)) {
                        return true;
                    }
                    result[current] = 0;
                    result[current + i] = 0;
                    used.remove(i);
                }
            }
        }

        return false;
    }
}
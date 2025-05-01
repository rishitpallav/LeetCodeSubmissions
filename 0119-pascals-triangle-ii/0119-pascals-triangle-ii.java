class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }

        for (int i = 1; i < rowIndex; i++ ) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 0; j < result.size()-1; j++ ) {
                newRow.add(result.get(j) + result.get(j+1));
            }
            newRow.add(1);
            result = newRow;
        }

        return result;
    }
}
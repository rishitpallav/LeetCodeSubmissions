class Solution {
    int result;
    boolean[] usedIndex;
    Set<String> encountered;

    public int numTilePossibilities(String tiles) {
        result = 0;
        usedIndex = new boolean[tiles.length()];
        encountered = new HashSet<>();

        findAllPossibilities(tiles, "");

        return encountered.size()-1;
    }

    void findAllPossibilities(String tiles, String current) {
        encountered.add(current);

        for (int i = 0; i < tiles.length(); i++ ) {
            if (!usedIndex[i]) {
                usedIndex[i] = true;
                findAllPossibilities(tiles, current+tiles.charAt(i));
                usedIndex[i] = false;
            }
        }
    }
}
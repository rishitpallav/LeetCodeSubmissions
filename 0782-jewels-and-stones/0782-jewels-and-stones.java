class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] jewelCount = new int[128];

        for (char c : jewels.toCharArray()) {
            jewelCount[c]++;
        }

        int result = 0;

        for (char c : stones.toCharArray()) {
            result += jewelCount[c];
        }

        return result;
    }
}
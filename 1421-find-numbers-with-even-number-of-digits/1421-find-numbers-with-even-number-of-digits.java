class Solution {
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if (divide(num) %2 == 0) {
                counter++;
            }
        }

        return counter;
    }

    public int divide (int num) {
        if (num == 0) return 0;
        return 1 + divide (num/10);
    }
}
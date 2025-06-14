class Solution {
    public int minMaxDifference(int num) {
        int large = -1;
        int small = -1;

        int value = num;

        while (value > 0) {
            int temp = value % 10;
            value /= 10;
            if (temp != 9) large = temp;
            if (temp != 0) small =  temp;
        }

        value = num;
        int result = 0;
        int counter = -1;

        while (value > 0) {
            int temp = value % 10;
            value /= 10;
            counter++;

            if (temp == small) {
                result += 9 * Math.pow(10, counter);
            } else if (temp == large) {
                result += (9 - temp) * Math.pow(10, counter);
            }
        }

        return result;
    }
}
class Solution {
    public int minMaxDifference(int num) {
        char large = ' ';
        char small = ' ';

        String value = num + "";

        for (int i = 0; i < value.length() && (large == ' ' || small == ' '); i++ ) {
            if (large == ' ' && value.charAt(i) != '9') {
                large = value.charAt(i);
            }
            if (small == ' ' && value.charAt(i) != '0') {
                small = value.charAt(i);
            }
        }

        int largest = Integer.parseInt(value.replaceAll(String.valueOf(large), "9"));
        int smallest = Integer.parseInt(value.replaceAll(String.valueOf(small), "0"));

        return largest - smallest;
    }
}
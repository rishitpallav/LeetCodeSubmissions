class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> numSet = new HashSet<>();

        int max = 0;

        for (String num : nums) {
            int n = Integer.parseInt(num, 2);
            numSet.add(n);
            max = Integer.max(max, n);
        }

        for (int i = 0; i < max; i++ ) {
            if (!numSet.contains(i)) {
                String binary = Integer.toBinaryString(i);
                return String.format("%" + nums[0].length() + "s", binary).replace(' ', '0');
            }
        }

        String binary = Integer.toBinaryString(max+1);
        return String.format("%" + nums[0].length() + "s", binary).replace(' ', '0');
    }
}
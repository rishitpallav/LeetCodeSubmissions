class Solution {
    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return new ArrayList<>();
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    void backtrack(String s, int index, List<String> currentAddress) {
        if (currentAddress.size() > 4) return;

        // System.out.printf("s=%s, index=%d, currentAddress=%s\n", s, index, String.join(".", currentAddress));

        if (index == s.length()) {
            if (isValidAddress(currentAddress)) {
                result.add(String.join(".", currentAddress));
                return;
            }
        }
        if (index >= s.length()) return;
        
        if (s.charAt(index) == '0') {
            currentAddress.add("0");
            backtrack(s, index+1, currentAddress);
            currentAddress.remove(currentAddress.size() - 1);
        } else {
            for (int i = 1; i <= 3 && index+i <= s.length(); i++ ) {
                String number = s.substring(index, index+i);
                if (!isValidNumber(number)) {
                    break;
                }
                currentAddress.add(number);
                backtrack(s, index+i, currentAddress);
                currentAddress.remove(currentAddress.size() - 1);
            }
        }
    }

    boolean isValidAddress(List<String> address) {
        if (address.size() != 4) return false;
        for (String s : address) {
            if (!isValidNumber(s)) {
                return false;
            }
        }
        return true;
    }

    boolean isValidNumber(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        if (Integer.parseInt(s) <= 255) return true;
        return false;
    }
}
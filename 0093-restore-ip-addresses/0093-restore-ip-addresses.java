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

        if (index == s.length() && currentAddress.size() == 4) {
            result.add(String.join(".", currentAddress));
            return;
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

    boolean isValidNumber(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        if (Integer.parseInt(s) <= 255) return true;
        return false;
    }
}
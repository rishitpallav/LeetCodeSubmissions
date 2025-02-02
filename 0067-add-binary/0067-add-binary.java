class Solution {
    public String addBinary(String a, String b) {
        int aL = a.length()-1;
        int bL = b.length()-1;

        boolean carry = false;
        boolean sum = false;

        StringBuffer result = new StringBuffer();

        while (aL >= 0 || bL >= 0 || carry) {
            boolean i1 = (aL >= 0 ? (a.charAt(aL)=='1'?true:false):false);
            boolean i2 = (bL >= 0 ? (b.charAt(bL)=='1'?true:false):false);
            boolean i3 = carry;

            boolean o1 = i1 ^ i2;
            boolean o2 = i1 & i2;

            sum = o1 ^ i3;

            boolean o3 = o1 & i3;
            
            carry = o2 | o3;

            result.append(sum?"1":"0");
            aL--;
            bL--;
        }

        return result.reverse().toString();
    }
}


/*

 A B C  S C
 0 0 0  0 0
 0 0 1  1 0
 0 1 0  1 0
 0 1 1  0 1
 1 0 0  1 0
 1 0 1  0 1
 1 1 0  0 1
 1 1 1  1 1

 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        sb.append((num/den));
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");

        HashMap<Long, Integer> numberToIndex = new HashMap<>();
        
        while (num > 0) {
            if (numberToIndex.containsKey(num)) {
                sb.insert(numberToIndex.get(num), "(");
                sb.append(")");
                break;
            }
            numberToIndex.put(num, sb.length());
            num *= 10;
            sb.append(num/den);
            num %= den;
        }

        return sb.toString();
    }
}
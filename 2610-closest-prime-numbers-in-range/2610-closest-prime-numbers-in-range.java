class Solution {
    public int[] closestPrimes(int left, int right) {
        int difference = Integer.MAX_VALUE;
        int least = -1;
        int most = -1;
        int previous = -1;

        for (int i = left; i <= right; i++ ) {
            if (isPrime(i)) {
                System.out.println(i);
                if (previous == -1) {
                    previous = i;
                    least = i;
                } else {
                    if (difference > i - previous) {
                        least = previous;
                        most = i;
                        difference = i - previous;
                        if (difference <= 2) {
                            return new int[]{least, most};
                        }
                    }
                }
                previous = i;
            }
        }

        if (most == -1) return new int[]{-1,-1};
        return new int[]{least, most};

    }

    boolean isPrime (int n) {
        if (n <= 1) {
            return false;
        }

        if (n <= 3) {
            return true;
        }

        if (n%2 == 0 || n%3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n%i == 0 || n % (i+2) == 0) {
                return false;
            }
        }

        return true;

    }
}
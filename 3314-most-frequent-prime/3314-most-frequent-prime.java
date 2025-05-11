class Solution {
    public int mostFrequentPrime(int[][] mat) {
        Map<Integer, Integer> mostFreq = new HashMap<>();
        for (int i = 0; i < mat.length; i++ ) {
            for (int j = 0; j < mat[0].length; j++ ) {
                List<Integer> elements = getAllNumbers(mat, i, j);
                for (int element : elements) {
                    mostFreq.put(element, mostFreq.getOrDefault(element, 0) + 1);
                }
            }
        }

        int mostFreqNumber = -1, frequency = 0;
        for (Map.Entry<Integer, Integer> entry : mostFreq.entrySet()) {
            if (frequency == entry.getValue()) {
                if (mostFreqNumber < entry.getKey()) {
                    mostFreqNumber = entry.getKey();
                }
            } else if (frequency < entry.getValue()) {
                mostFreqNumber = entry.getKey();
                frequency = entry.getValue();
            }
        }

        return mostFreqNumber;
    }

    List<Integer> getAllNumbers(int[][] mat, int x, int y) {
        int n = mat.length, m = mat[0].length;
        List<Integer> result = new ArrayList<>();

        // East
        int number = 0;
        for (int j = y; j < m; j++ ) {
            number *= 10;
            number += mat[x][j];
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // South-East
        number = 0;
        int i = x, j = y;
        while (i < n && j < m) {
            number *= 10;
            number += mat[i][j];
            i++;j++;
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // South
        number = 0;
        for (i = x; i < n; i++ ) {
            number *= 10;
            number += mat[i][y];
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // South-West
        number = 0;
        i = x; j = y;
        while (j >= 0 && i < n ) {
            number *= 10;
            number += mat[i][j];
            i++; j--;
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // West
        number = 0;
        for (j = y; j >= 0; j-- ) {
            number *= 10;
            number += mat[x][j];
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // North-West
        number = 0;
        i = x; j = y;
        while (i >= 0 && j >= 0) {
            number *= 10;
            number += mat[i][j];
            i--; j--;
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // North
        number = 0;
        for (i = x; i >= 0; i-- ) {
            number *= 10;
            number += mat[i][y];
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        // North-East
        number = 0;
        i = x; j = y;
        while (i >= 0 && j < m) {
            number *= 10;
            number += mat[i][j];
            i--; j++;
            if (number > 10 && isPrime(number))
                result.add(number);
        }

        return result;

    }

    boolean isPrime (int n) {
        if (n < 2) return false;
        if (n < 4) return true;

        if (n%2 == 0 || n%3 == 0) return false;

        for (int i = 5; i * i <= n; i+= 6) {
            if (n%i == 0 || n % (i+2) == 0) return false;
        }

        return true;
    }
}
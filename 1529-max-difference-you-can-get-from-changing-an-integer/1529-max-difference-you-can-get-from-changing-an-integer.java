class Solution {
    public int maxDiff(int num) {
        String numVal = String.valueOf(num);

        char[] most = numVal.toCharArray();
        char[] least = Arrays.copyOf(most, most.length);

        if (most[0] == '9') {
            int index = 1;
            while (index < most.length && most[index] == '9') {
                index++;
            }
            if (index < most.length) {
                char replace = most[index];
                most[index] = '9';
                for (int i = index+1; i < most.length; i++ ) {
                    if (most[i] == replace) {
                        most[i] = '9';
                    }
                }
            }
        } else {
            char replace = most[0];
            most[0] = '9';
            for (int i = 1; i < most.length; i++ ) {
                if (most[i] == replace) {
                    most[i] = '9';
                }
            }
        }

        if (least[0] == '1') {
            int index = 1;
            while (index < least.length && (least[index] == '0' || least[index] == '1')) {
                index++;
            }
            if (index < least.length) {
                char replace = least[index];
                least[index] = '0';
                for (int i = index+1; i < least.length; i++ ) {
                    if (least[i] == replace) {
                        least[i] = '0';
                    }
                }
            }
        } else {
            char replace = least[0];
            least[0] = '1';
            for (int i = 1; i < least.length; i++ ) {
                if (least[i] == replace) {
                    least[i] = '1';
                }
            }
        }

        System.out.println(Arrays.toString(least));
        System.out.println(Arrays.toString(most));

        int l = 0;
        for (int i : least) {
            l = (l*10) + (i - '0');
        }
        int m = 0;
        for (int i : most) {
            m = (m*10) + (i - '0');
        }

        return m - l;
    }
}
class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for(int i = 0; i < arr.length; i++ ) {
            pq.add(new int[] {countBits(arr[i]), arr[i]});
        }

        for (int i = 0; i < arr.length; i++ ) {
            arr[i] = pq.poll()[1];
        }

        return arr;
    }

    int countBits(int n) {
        int x = 1;
        int counter = 0;

        while (n > 0) {
            counter += ((x & n) == 0)?0:1;
            n = n>>1;
        }

        return counter;
    }
}
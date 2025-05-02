class Solution {
    class Pair {
        char c;
        int count;
        Pair (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {
        int[] chars = new int[26];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (int i = 0; i < s.length(); i++ ) chars[s.charAt(i)-'a']++;
        for (int i = 0; i < 26; i++ ) if(chars[i] > 0) maxHeap.add(new Pair((char)(i+'a'), chars[i]));

        StringBuilder result = new StringBuilder();
        Pair currentMaxPair = maxHeap.poll();

        while (currentMaxPair != null) {
            result.append(currentMaxPair.c);
            Pair nextMaxPair = (maxHeap.size() > 0) ? maxHeap.poll() : null;
            currentMaxPair.count = currentMaxPair.count - 1;
            if (currentMaxPair.count > 0)
                maxHeap.add(currentMaxPair);
            currentMaxPair = nextMaxPair;
        }
        if (maxHeap.size() > 0) return "";

        return result.toString();
    }
}
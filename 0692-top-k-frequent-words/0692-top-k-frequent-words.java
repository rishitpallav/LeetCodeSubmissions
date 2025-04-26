class Solution {

    class Pair {
        String val;
        int count;

        Pair(String val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.count != a.count) {
                return b.count - a.count;
            } else {
                return a.val.compareTo(b.val);
            }
        });

        Map<String, Integer> counter = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        while (k -- > 0) {
            result.add(pq.poll().val);
        }

        return result;
    }
}
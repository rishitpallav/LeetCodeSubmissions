class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            ticketsMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> current = new ArrayList<>();
        dfs("JFK", ticketsMap, current);

        Collections.reverse(current);
        
        return current;
    }

    void dfs(String source, Map<String, PriorityQueue<String>> ticketsMap, List<String> current) {
        
        PriorityQueue<String> queue = ticketsMap.get(source);
        
        while (queue != null && !queue.isEmpty()) {
            String destination = queue.poll();
            dfs(destination, ticketsMap, current);
        }
        current.add(source);
    }
}
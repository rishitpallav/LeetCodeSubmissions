class TimeMap {

    Map<String, List<Pair<Integer, String>>> database;

    public TimeMap() {
        database = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        database.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> current = database.getOrDefault(key, new ArrayList<>());

        int left = 0;
        int right = current.size() - 1;

        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (current.get(mid).getKey() <= timestamp) {
                result = current.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
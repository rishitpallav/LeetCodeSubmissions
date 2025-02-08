class NumberContainers {

    // Use to store index as key and number at that index as value
    Map<Integer, Integer> containerMap;
    // Use to store number as a key and indices as value
    Map<Integer, Set<Integer>> indexMap;
    // Use a cache to store the minimum index present for a number and cache elimination strategy is whenever a new index replaces cache value
    Map<Integer, Integer> cache;

    public NumberContainers() {
        containerMap = new HashMap<>();
        indexMap = new HashMap<>();
        cache = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (containerMap.containsKey(index)) {
            // Update the indexMap
            Set<Integer> value = indexMap.get(containerMap.get(index));
            value.remove(index);
            indexMap.put(containerMap.get(index), value);
            if (cache.containsKey(containerMap.get(index))) {
                if (index == cache.get(containerMap.get(index))) {
                    cache.remove(containerMap.get(index));
                }
            }
        }
        // Update the containerMap
        containerMap.put(index, number);
        // Add the number to the indexMap
        Set<Integer> value = indexMap.getOrDefault(number, new HashSet<>());
        value.add(index);
        indexMap.put(number, value);
        if (cache.containsKey(number)) {
            cache.put(number, Math.min(index, cache.get(number)));
        }
    }
    
    public int find(int number) {
        if (!indexMap.containsKey(number)) {
            return -1;
        }
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        int minValue = Integer.MAX_VALUE;
        Set<Integer> value = indexMap.get(number);
        for (Integer x : value) {
            minValue = Math.min(minValue, x);
        }

        

        if (minValue!=Integer.MAX_VALUE) {
            cache.put(number, minValue);
            return minValue;
        } else {
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
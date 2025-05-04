class RandomizedSet {

    Map<Integer, Integer> allElements;
    ArrayList<Integer> list;

    public RandomizedSet() {
        allElements = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (allElements.containsKey(val)) {
            return false;
        }

        list.add(val);
        allElements.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!allElements.containsKey(val)) return false;

        int index = allElements.get(val);
        list.set(index, list.get(list.size() - 1));
        allElements.put(list.get(index), index);

        list.remove(list.size() -1);
        allElements.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
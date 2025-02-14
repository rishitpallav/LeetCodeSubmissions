class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();

        Queue<Integer> bfs = new LinkedList<>();

        keys.add(0);
        bfs.add(0);

        while (!bfs.isEmpty()) {
            List<Integer> allKeysInRoom = rooms.get(bfs.poll());
            for (int key : allKeysInRoom) {
                if (!keys.contains(key)) {
                    bfs.add(key);
                    keys.add(key);
                }
            }
        }

        return (keys.size() == rooms.size())?true:false;
    }
}
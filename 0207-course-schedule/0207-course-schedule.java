class Solution {
    boolean[] visited;
    boolean[] current;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        current = new boolean[numCourses];
        Map<Integer, List<Integer>> prereqs = new HashMap<>();

        for (int[] p : prerequisites) prereqs.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);

        for (int i = 0; i < numCourses; i++ ) {
            if (visited[i]) continue;
            if (isCycle(prereqs, i)) {
                return false;
            }
        }

        return true;
    }

    boolean isCycle(Map<Integer, List<Integer>> prereqs, int course) {
        if (current[course]) return true;
        if (visited[course]) return false;
        if (!prereqs.containsKey(course)) return false;

        for (int prereq : prereqs.get(course)) {
            current[course] = true;
            if (isCycle(prereqs, prereq)) {
                return true;
            }
            current[course] = false;
        }

        visited[course] = true;
        return false;
    }
}
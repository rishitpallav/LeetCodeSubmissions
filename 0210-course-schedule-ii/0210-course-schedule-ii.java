class Solution {
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] prereqs = new ArrayList[numCourses];

        for (int[] prerequisite : prerequisites) {
            if (prereqs[prerequisite[1]] == null) prereqs[prerequisite[1]] = new ArrayList<>();
            prereqs[prerequisite[1]].add(prerequisite[0]);
        }

        int[] result = new int[numCourses];
        index = numCourses - 1;

        // Keep track of cycles
        boolean[] visited = new boolean[numCourses];
        // Keep track of completed courses
        boolean[] checked = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++ ) {
            if (getCourses(prereqs, i, visited, checked, result)) {
                return new int[0];
            }
        }

        return result;
    }

    boolean getCourses(List<Integer>[] prereqs, int course, boolean[] visited, boolean[] checked, int[] result) {

        if (visited[course]) {
            return true;
        }

        if (checked[course]) {
            return false;
        }

        visited[course] = true;

        if (prereqs[course] != null) {
            for (int c : prereqs[course]) {
                if (getCourses(prereqs, c, visited, checked, result)) {
                    return true;
                }
            }
        }

        checked[course] = true;
        visited[course] = false;
        result[index--] = course;
        
        return false;
    }
}
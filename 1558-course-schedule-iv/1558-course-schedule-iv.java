class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] pre = new ArrayList[numCourses];
        List<Boolean> result = new ArrayList<>();
        
        for (int i =0 ; i < numCourses; i++ ) {
            pre[i] = new ArrayList<Integer>();
        }

        for (int[] p : prerequisites) {
            pre[p[0]].add(p[1]);
        }

        Set<Integer>[] allPre = new HashSet[numCourses];

        for (int i =0 ; i < numCourses; i++ ) {
            allPre[i] = new HashSet<Integer>();
            dfs(i, pre, allPre, i);
        }

        for(int[] q : queries) {
            if (allPre[q[0]].contains(q[1])) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    void dfs(int currentCourse, List<Integer>[] pre, Set<Integer>[] allPre, int course) {
        for (int i : pre[currentCourse]) {
            if (allPre[course].contains(i))
                continue;
            dfs(i, pre, allPre, course);
            allPre[course].add(i);
        }
    }
}
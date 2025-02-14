class Solution {
    int longestDistance = 0;

    public int longestPath(int[] parent, String s) {
        if (parent.length == 1) {
            return 1;
        }
        Map<Integer, List<Integer>> connectedDown = new HashMap<>();

        for (int i = 1; i < parent.length; i++ ) {
            List<Integer> currentList = connectedDown.getOrDefault(parent[i], new ArrayList<>());
            currentList.add(i);
            connectedDown.put(parent[i], currentList);
        }

        travel(0, connectedDown, s);

        return longestDistance;
    }

    int travel(int i, Map<Integer, List<Integer>> connectedDown, String s) {
        // If we reach the end of any place
        if (!connectedDown.containsKey(i)) {
            return 1;
        }

        // As there are only 2 paths we can take
        int longest = 0;
        int secondLongest = 0;

        for (int element : connectedDown.get(i) ) {
            int currentLength = travel(element, connectedDown, s);
            if (s.charAt(i) != s.charAt(element)) {
                if (longest < currentLength) {
                    secondLongest = longest;
                    longest = currentLength;
                } else if (secondLongest < currentLength) {
                    secondLongest = currentLength;
                }
            }
        }

        longestDistance = Math.max(longestDistance, longest + secondLongest + 1);

        return longest + 1;
    }
}
class Twitter {

    int t;
    Map<Integer, List<int[]>> usersAndPostsMap;
    Map<Integer, Set<Integer>> followList;

    public Twitter() {
        t = 0;
        usersAndPostsMap = new HashMap<>();
        followList = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        usersAndPostsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, t});
        if (usersAndPostsMap.get(userId).size() > 10) {
            usersAndPostsMap.get(userId).remove(0);
        }
        t++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> posts = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        followList.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for (int followingUser : followList.get(userId)) {
            List<int[]> postsByFollowingUser = new ArrayList<>();
            if (usersAndPostsMap.containsKey(followingUser)) {
                postsByFollowingUser = usersAndPostsMap.get(followingUser);
            }
            for (int[] post : postsByFollowingUser) {
                posts.add(post);
                if (posts.size() > 10) {
                    posts.poll();
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!posts.isEmpty()) {
            result.add(0, posts.poll()[0]);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followList.containsKey(followerId))
            followList.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
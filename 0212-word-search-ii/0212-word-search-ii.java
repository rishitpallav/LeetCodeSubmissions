class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }


    // Trial using multi-threading. Please check the previous commit for regular solution.
    // Doesn't change much. I added executor service.

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        TrieNode root = buildTrie(words);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < board.length; i++ ) {
            for (int j = 0; j < board[0].length; j++ ) {
                    final int x = i, y = j;
                    futures.add(executor.submit(() -> {
                        dfs(board, root, x, y, result);
                    }));
            }
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.word = word;
        }

        return root;
    }

    private void dfs(char[][] board, TrieNode current, int i, int j, List<String> result) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*' || current.children[board[i][j] - 'a'] == null) {
            return;
        }

        char c = board[i][j];
        TrieNode next = current.children[c - 'a'];

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }


        board[i][j] = '*';

        dfs(board, next, i+1, j, result);
        dfs(board, next, i-1, j, result);
        dfs(board, next, i, j+1, result);
        dfs(board, next, i, j-1, result);

        board[i][j] = c;
        
        return;
    }
}

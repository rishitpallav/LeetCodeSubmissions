class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndWord = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (temp.children[idx] == null) {
                temp.children[idx] = new TrieNode();
            }
            temp = temp.children[idx];
        }
        temp.isEndWord = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        return dfs(word.toCharArray(), temp, 0);
    }

    boolean dfs(char[] word, TrieNode current, int index) {
        if (index == word.length) {
            return current.isEndWord;
        }
        char c = word[index];
        
        if (c == '.') {
            for (TrieNode child : current.children) {
                if (child != null && dfs(word, child, index+1)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            if (current.children[idx] == null) {
                return false;
            }
            return dfs(word, current.children[idx], index+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
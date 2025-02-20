class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
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
            temp.children.putIfAbsent(c, new TrieNode());
            temp = temp.children.get(c);
        }
        temp.isEndWord = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        return dfs(word, temp, 0);
    }

    boolean dfs(String word, TrieNode current, int index) {
        if (index == word.length()) {
            return current.isEndWord;
        }
        if (current == null) {
            return false;
        }
        char c = word.charAt(index);
        
        if (c == '.') {
            for (TrieNode child : current.children.values()) {
                if (dfs(word, child, index+1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!current.children.containsKey(c)) {
                return false;
            }
            return dfs(word, current.children.get(c), index+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
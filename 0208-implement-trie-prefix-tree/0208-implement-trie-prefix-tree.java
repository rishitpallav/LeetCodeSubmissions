class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Trie {

    Map<Character, TrieNode> mainTrie;

    public Trie() {
        mainTrie = new HashMap<>();
    }
    
    public void insert(String word) {
        Map<Character, TrieNode> temp = mainTrie;
        for (char c : word.toCharArray()) {
            temp.putIfAbsent(c, new TrieNode());
            temp = temp.get(c).children;
        }
        temp.put('*', null);
    }
    
    public boolean search(String word) {
        Map<Character, TrieNode> temp = mainTrie;
        for (char c : word.toCharArray()) {
            if (temp.containsKey(c)) {
                temp = temp.get(c).children;
            } else {
                return false;
            }
        }
        if (temp.containsKey('*')) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        Map<Character, TrieNode> temp = mainTrie;
        for (char c : prefix.toCharArray()) {
            if (temp.containsKey(c)) {
                temp = temp.get(c).children;
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class TrieNode {
    HashMap<Character, TrieNode> next;
    boolean isEnd;
    TrieNode() {
        next = new HashMap<>();
        isEnd = false;
    }
}
class Solution {

    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));
        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            if (canConcatenate(word, 0, root, 0)) {
                result.add(word);
            } else {
                addWordToTrie(word);
            }
        }

        return result;
    }

    void addWordToTrie(String word) {
        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            temp.next.putIfAbsent(c, new TrieNode());
            temp = temp.next.get(c);
        }

        temp.isEnd = true;
    }

    boolean canConcatenate(String word, int index, TrieNode current, int splits) {
        if (index == word.length()) {
            return splits > 0 && current.isEnd;
        }

        char c = word.charAt(index);
        TrieNode nextNode = current.next.get(c);

        if (nextNode == null) return false;

        return (nextNode.isEnd && canConcatenate(word, index+1, root, splits+1)) || canConcatenate(word, index+1, nextNode, splits);
    }
}
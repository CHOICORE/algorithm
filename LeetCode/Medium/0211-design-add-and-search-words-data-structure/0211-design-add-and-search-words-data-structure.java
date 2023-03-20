class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    
    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class WordDictionary {
    
    private TrieNode root;

    // Trie 초기화
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Trie 에 추가
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchRecursive(root, word, 0);
    }
    
    private boolean searchRecursive(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        
        char c = word.charAt(index);
        if (c != '.') {
            if (!node.children.containsKey(c)) {
                return false;
            }
            return searchRecursive(node.children.get(c), word, index + 1);
        } else {
            for (TrieNode child : node.children.values()) {
                if (searchRecursive(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

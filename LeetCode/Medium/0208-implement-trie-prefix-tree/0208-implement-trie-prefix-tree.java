class Trie {

    Trie[] arr;
    boolean end;

    public Trie() {
        arr = new Trie[26];
    }

    public void insert(String word) {
        insert(word.toCharArray(), 0);
    }

    public void insert(final char[] word, int index) {
        if (index >= word.length)
            return;
        Trie trie = arr[word[index] - 'a'];
        if (trie == null)
            trie = new Trie();
        if (index == word.length - 1)
            trie.end = true;
        arr[word[index] - 'a'] = trie;
        trie.insert(word, index + 1);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0);
    }

    public boolean search(final char[] word, int index) {
        if (index >= word.length)
            return true;
        Trie trie = arr[word[index] - 'a'];
        if (trie == null)
            return false;
        if (index == word.length - 1)
            return trie.end;
        return trie.search(word, index + 1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix.toCharArray(), 0);
    }

    public boolean startsWith(final char[] word, int index) {
        if (index >= word.length)
            return true;
        Trie trie = arr[word[index] - 'a'];
        if (trie == null)
            return false;
        return trie.startsWith(word, index + 1);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
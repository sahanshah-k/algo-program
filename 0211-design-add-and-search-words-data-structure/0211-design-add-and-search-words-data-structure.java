class TrieNode {
    
    TrieNode[] children;
    boolean isEnd;
    
    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
    
}


class WordDictionary {

    private final TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i ++) {
            int v = word.charAt(i) - 'a';
            if (curr.children[v] == null) {
                curr.children[v] = new TrieNode();
            }
            curr = curr.children[v];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        return dfs(curr, 0, word);
    }
    
    public boolean dfs(TrieNode curr, int k, String word) {
        for (int i = k; i < word.length(); i ++) {
            int v = word.charAt(i) - 'a';
            if (v == -51) {
                for (int j = 0; j < 26; j ++) {
                    if (curr.children[j] != null && dfs(curr.children[j], i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[v] == null) {
                    return false;
                }
                curr = curr.children[v];
            }
        }
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
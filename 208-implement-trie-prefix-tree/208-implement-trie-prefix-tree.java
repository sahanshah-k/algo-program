class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    
    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        for (int i = 0; i < word.length(); i ++) {
            int v = word.charAt(i) - 'a';
            if (curr.children[v] == null) {
                return false;
            }
            curr = curr.children[v];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i ++) {
            int v = prefix.charAt(i) - 'a';
            if (curr.children[v] == null) {
                return false;
            }
            curr = curr.children[v];
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
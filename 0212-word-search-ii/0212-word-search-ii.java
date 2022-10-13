class Solution {
//     public List<String> findWords(char[][] board, String[] words) {
//         Set<String> out = new HashSet<>();
//         for (String s: words) {
//             for (int i = 0; i < board.length; i ++) {
//                 for (int j = 0; j < board[0].length; j ++) {
//                     boolean[][] visited = new boolean[board.length][board[0].length];
//                     if (s.charAt(0) == board[i][j] && helper(board, i, j, 0, s, visited)) {
//                         out.add(s);            
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(out);
//     }
    
//     boolean helper(char[][] b, int i, int j, int k, String word, boolean[][] visited) {
//         if (i < 0 || i > b.length - 1 || j < 0 || j > b[0].length - 1 || visited[i][j] || b[i][j] != word.charAt(k)) {
//             return false;
//         }
        
//         visited[i][j] = true;
        
//         if (k == word.length() - 1) {
//             return true;
//         }
        
//         if (helper(b, i + 1, j, k + 1, word, visited)
//             || helper(b, i, j + 1, k + 1, word, visited)
//             || helper(b, i - 1, j, k + 1, word, visited)
//             || helper(b, i, j - 1, k + 1, word, visited)) {
//             return true;
//         }
//         visited[i][j] = false;
//         return false;
//     }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> out = new ArrayList<>();
        TrieNode trie = buildTrie(words);
        
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                helper(board, i, j, out, trie, visited);
            }
        }        
        return out;
    }
    
    private void helper(char[][] b, int i, int j, List<String> out, TrieNode trie, boolean[][] visited) {
        if (i < 0 || i > b.length - 1 || j < 0 || j > b[0].length - 1 || visited[i][j]) {
            return;
        }
        
        int v = b[i][j] - 'a';
    
        if (trie.children[v] == null) {
            return;
        }
        
        visited[i][j] = true;
        
        trie = trie.children[v];
        
        if (trie.word != null) {
            out.add(trie.word);
            trie.word = null;
        }
        
        helper(b, i + 1, j, out, trie, visited);
        helper(b, i, j + 1, out, trie, visited);
        helper(b, i - 1, j, out, trie, visited);
        helper(b, i, j - 1, out, trie, visited);
        
        visited[i][j] = false;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w: words) {
            TrieNode curr = root;
            for (int i = 0; i < w.length(); i ++) {
                int v = w.charAt(i) - 'a';
                if (curr.children[v] == null) {
                    curr.children[v] = new TrieNode();
                }
                curr = curr.children[v];
            }
            curr.word = w;
        }
        return root;
    }
    
}

class TrieNode {
    TrieNode[] children;
    String word;
    
    TrieNode() {
        children = new TrieNode[26];
    }
}
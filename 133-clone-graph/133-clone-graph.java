/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> cache = new HashMap<>();
        return dfs(node, cache);
    }
    
    private Node dfs(Node node, HashMap<Node, Node> cache) {
        
        if (node == null) {
            return null;
        }
        
        if (cache.containsKey(node)) {
            return cache.get(node);
        }
        
        Node copy = new Node(node.val);
        cache.put(node, copy);
        for (Node neig: node.neighbors) {
            copy.neighbors.add(dfs(neig, cache));
        }
        
        return copy;
    }
}
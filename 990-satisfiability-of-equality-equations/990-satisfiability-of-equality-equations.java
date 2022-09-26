class Solution {
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        
        for (int i = 0; i < 26; i ++) {
            parent[i] = i;
        }
        
        for (String eq: equations) {
            if (eq.charAt(1) == '=') {
                int v1 = findParent(eq.charAt(0) - 'a', parent);
                int v2 = findParent(eq.charAt(3) - 'a', parent);
                
                    parent[v2] = v1; 
                
            }
        }
        
        for (String eq: equations) {
            if (eq.charAt(1) == '!') {
                int v1 = findParent(eq.charAt(0) - 'a', parent);
                int v2 = findParent(eq.charAt(3) - 'a', parent);
                
                if (v1 == v2) {
                    return false;
                }                
            }
        }
        
        return true;
    }
    
    private int findParent(int index, int[] parent) {
        if (parent[index] == index) {
            return index;
        }
        return findParent(parent[index], parent);
    }
}
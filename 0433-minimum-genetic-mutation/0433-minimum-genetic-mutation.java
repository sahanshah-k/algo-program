class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        
        q.offer(start);
        seen.add(start);
        int steps = 0;
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i ++) {
                String node = q.remove();
                
                if (node.equals(end)) {
                    return steps;
                }
                
                for (int j = 0; j < choices.length; j ++) {
                    for (int k = 0; k < node.length(); k ++) {
                        String neighbour = node.substring(0, k) + choices[j] + node.substring(k + 1);
                        if (!seen.contains(neighbour) && Arrays.asList(bank).contains(neighbour)) {
                            q.offer(neighbour);
                            seen.add(neighbour);
                        }
                    }       
                }
            }
            steps ++;
        }
        return -1;
    }
}
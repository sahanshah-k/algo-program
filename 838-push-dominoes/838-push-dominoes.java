class Solution {
    public String pushDominoes(String dominoes) {
        
        char[] ca = dominoes.toCharArray();
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < ca.length; i ++) {
            if (ca[i] != '.') {
                q.add(i);
            }
        }
        int skip = 0;
        int skipStartIndex = -1;
        while (!q.isEmpty()) {            
            int index = q.remove();
            if (skip > 0) {
                skip = skip - (index - skipStartIndex);
                continue;
            }
            if (ca[index] == 'L') {
                if (index > 0 && ca[index - 1] == '.') {
                    ca[index - 1] = 'L';
                    q.add(index - 1);
                }
            } else if (ca[index] == 'R') {
                if (index < ca.length - 1 && ca[index + 1] == '.') {
                    if (index < ca.length - 2 && ca[index + 1] == '.' && ca[index + 2] == 'L') {
                        skip = 2;
                        skipStartIndex = index;
                        continue;
                    } else {
                        ca[index + 1] = 'R';
                        q.add(index + 1);
                    }
                }
            }
        }
        
        return new String(ca);
    }

}
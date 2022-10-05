class Solution {
    public String longestPalindrome(String s) {
        int[] sol = new int[] {Integer.MIN_VALUE, 0, 0};
        HashMap<String, Boolean> dp = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            for (int j = i + 1; j < s.length(); j ++) {
                String sub = s.substring(i, j + 1);
                // if (dp.containsKey(sub)) {
                //     continue;
                // }
                // dp.put(sub, verify(sub));
                if ((j - i + 1) > sol[0] && verify(sub)) {
                    sol[0] = j - i + 1;
                    sol[1] = i;
                    sol[2] = j;
                } 
            }
        }
        return s.substring(sol[1], sol[2] + 1);
    }
    
    private boolean verify(String s) {
        int r = s.length() - 1;
        for (int l = 0; l < s.length() / 2; l++, r--) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
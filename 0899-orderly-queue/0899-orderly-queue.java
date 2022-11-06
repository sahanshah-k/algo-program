class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i ++) {
                s = s.substring(1) + s.charAt(0);
                if (s.compareTo(ans) < 0) {
                    ans = s;
                }
            }
            return ans;
        } else {
            char[] ans = s.toCharArray();
            Arrays.sort(ans);
            return new String(ans);
        }
    }
}
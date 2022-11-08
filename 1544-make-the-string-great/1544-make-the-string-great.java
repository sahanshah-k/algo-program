class Solution {
    public String makeGood(String s) {
        if (s.isEmpty()) {
            return "";
        }
        boolean containsUpper = true;
        
        while(containsUpper) {
            StringBuilder sb = new StringBuilder();
            containsUpper = false;
            for (int i = 0; i < s.length(); i ++) {
                if (i + 1 < s.length() && check((int) s.charAt(i), (int) s.charAt(i + 1))) {
                    i = i + 1;
                    containsUpper = true;
                    continue;
                }
                sb.append(s.charAt(i));
            }
            
            s = sb.toString();
        }
        
        return s;
        
    }
    
    
    boolean check(int a, int b) {
        if (a >= 65 && a <= 90 && b >= 97 && b <= 122 && (a + 32) == b) {
            return true;
        } else if (b >= 65 && b <= 90 && a >= 97 && a <= 122 && (a - 32) == b) {
            return true;
        } else {
            return false;
        }
    }
}
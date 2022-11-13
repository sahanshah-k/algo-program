class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        char[] ca = s.toCharArray();
        int l = ca.length - 1, r = ca.length - 1;
        while (l >= 0) {
            while (l >= 0 && ca[l] != ' ') {
                l --;
            }
            System.out.println(l + " " + r + " " + new String(ca, l + 1, r - l));
            sb.append(new String(ca, l + 1, r - l));
            if (l != -1) {
                sb.append(" ");
            }
            while (l >= 0 && ca[l] == ' ') {
                l --;
            }
            while ( r >= 0 && ca[r] != ' ') {
                r --;
            }
            while (r >= 0 && ca[r] == ' ') {
                r --;
            }
        }
        return sb.toString();
    }
}
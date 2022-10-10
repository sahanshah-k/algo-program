class Solution {
    public String breakPalindrome(String palindrome) {
        
        if (palindrome.length() == 1) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        boolean replaced = false;
        
        for (int i = 0; i < palindrome.length(); i ++) {
            char ch = palindrome.charAt(i);
            if (ch != 'a' && !replaced && i != palindrome.length() / 2) {
                sb.append('a');
                replaced = true;
            } else {
                sb.append(ch);
            }
        } 
        
        if (!replaced) {
            sb.setLength(sb.length() - 1);
            sb.append('b');
        }
        return sb.toString();
    }
}
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String i = "1";
        while (n > 1) {
            i = helper(i);
            n --;
        }
        return i;   
    }
    
    String helper(String num) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < num.length(); i ++) {
            if (num.charAt(i) != num.charAt(i - 1)) {
                sb.append(count)
                    .append(num.charAt(i - 1));
                count = 0;
            }
            count ++;
        }
        sb.append(count)
            .append(num.charAt(num.length() - 1));
        return sb.toString();
    }
    
}
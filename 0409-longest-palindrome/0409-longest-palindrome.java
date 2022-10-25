class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int out = 0;
        boolean oddAdded = false;
        for (Integer i: map.values()) {
            if (i % 2 == 0) {
                out += i;
            } else if (i % 2 != 0 && !oddAdded) {
                out += i;
                oddAdded = true;
            } else if (i % 2 != 0) {
                out += i - 1;
            } 
        }
        return out;
    }
}
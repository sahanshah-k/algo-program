class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> hash = new HashSet<>();
        int max = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i ++) {
            Character ch = s.charAt(i);
            if (hash.contains(ch)) {
                max = Math.max(max, current);
                i = i - current;
                current = 0;
                hash.clear();
                continue;
            }
            if (i == s.length() - 1) {
                max = Math.max(max, current + 1);
                break;
            }
            hash.add(ch);
            current ++;
        }
        return max;
    }
}
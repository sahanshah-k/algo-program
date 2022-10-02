class Solution {
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashSet<Character> hash = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
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
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow));
                slow ++;
            } else {
                set.add(s.charAt(fast));
                fast ++;
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
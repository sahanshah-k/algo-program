class Solution {
    public int characterReplacement(String s, int k) {
        int p1 = 0, p2 = 0;
        int outMax = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (p2 < s.length()) {
            map.put(s.charAt(p2), map.getOrDefault(s.charAt(p2), 0) + 1);
            while ((p2 - p1 + 1) - Collections.max(map.values()) > k) {
                map.put(s.charAt(p1), map.get(s.charAt(p1)) - 1);
                p1 ++;
            }
            outMax = Math.max(outMax, p2 - p1 + 1);
            p2 ++;
        }
        
        return outMax;
    }
}
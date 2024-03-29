class Solution {
    // public boolean isIsomorphic(String s, String t) {
    //     Map<Character, Character> map1 = new HashMap<>();
    //     Map<Character, Character> map2 = new HashMap<>();
    //     for (int i = 0; i < s.length(); i ++) {
    //         char c1 = s.charAt(i);
    //         char c2 = t.charAt(i);
    //         if (map2.containsKey(c2) && map2.get(c2) != c1) {
    //             return false;
    //         }
    //         if (map1.containsKey(c1) && map1.get(c1) != c2) {
    //             return false;
    //         }
    //         map1.put(c1, c2);
    //         map2.put(c2, c1);
    //     }
    //     return true;
    // }
    public boolean isIsomorphic(String s, String t) {
        return transform(s).equals(transform(t));
    }  
    
    private String transform(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
            
            sb.append(map.get(ch)).append(" ");
        }
        return sb.toString();
    }
}
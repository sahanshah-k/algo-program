class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     HashMap<String, List<String>> map = new HashMap<>();
    //     for (String s: strs) {
    //         char[] chArray = s.toCharArray();
    //         Arrays.sort(chArray);
    //         String key = new String(chArray);
    //         map.put(key, map.getOrDefault(key, new ArrayList<String>()));
    //         map.get(key).add(s);
    //     }
    //     return new ArrayList<>(map.values());
    // }
    
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     HashMap<String, List<String>> map = new HashMap<>();
    //     for (String s: strs) {
    //         char[] chArray = new char[26];
    //         for (char c: s.toCharArray()) {
    //             chArray[c - 'a'] += 1;
    //         }
    //         String key = new String(chArray);
    //         map.put(key, map.getOrDefault(key, new ArrayList<String>()));
    //         map.get(key).add(s);
    //     }
    //     return new ArrayList<>(map.values());
    // }
    
     public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> map = new HashMap<>();
         for (String s: strs) {
             char[] sArray = s.toCharArray();
             Arrays.sort(sArray);
             String sortedString = new String(sArray);
             map.put(sortedString, map.getOrDefault(sortedString, new ArrayList<>()));
             map.get(sortedString).add(s);
         }
         return new ArrayList<>(map.values());
     }
}
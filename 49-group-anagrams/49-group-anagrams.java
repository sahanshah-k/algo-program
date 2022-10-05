class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String key = new String(chArray);
            map.put(key, map.getOrDefault(key, new ArrayList<String>()));
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        boolean mid = false;
        int count = 0;
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String word = entry.getKey();
            int subCount = entry.getValue();
            
            if (word.charAt(1) == word.charAt(0)) {
                if (subCount % 2 == 0) {
                    count = count + subCount;
                } else {
                    count = count + subCount - 1;
                    mid = true;
                }
            } else {
                String reverse = new String(new char[]{word.charAt(1), word.charAt(0)});
                if (map.containsKey(reverse)) {
                    count += Math.min(map.get(reverse), map.get(word));
                }
            }
            
        }
        return count*2 + (mid ? 2 : 0);
    }
}
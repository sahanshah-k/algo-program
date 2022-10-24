class Solution {
    // public int maxLength(List<String> arr) {
    //     int max = 0;
    //     arr.add("");
    //     for (int i = 0; i < arr.size(); i ++) {
    //         StringBuilder sb = new StringBuilder(arr.get(i));
    //         for (int j = i + 1; j < arr.size(); j ++) {
    //             StringBuilder tmp = new StringBuilder(sb);
    //             tmp.append(arr.get(j));
    //             if (isUnique(tmp.toString())) {
    //                 sb.append(arr.get(j));   
    //                 if (sb.length() > max) {
    //                     max = sb.length();
    //                 }
    //             }
    //         }
    //     }
    //     return max;
    // }
    public int maxLength(List<String> arr) {
        return dfs(0, arr, new ArrayList<String>(), 0);
    }
    
    int dfs(int i, List<String> arr, List<String> sub, int max) {
        if (i >= arr.size()) {
            String s = String.join("", sub);
            if (isUnique(s)) {
                if (s.length() > max) {
                    max = s.length();
                }
                return max;
            }
            return max;
        }
        sub.add(arr.get(i));
        int include = dfs(i + 1, arr, sub, max);
        sub.remove(arr.get(i));
        int exclude = dfs(i + 1, arr, sub, max);
        return include > exclude ? include : exclude;
    }
    
    private boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i ++) {
            Character ch = str.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
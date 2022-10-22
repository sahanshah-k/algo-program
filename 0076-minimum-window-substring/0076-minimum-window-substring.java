class Solution {
//     public String minWindow1(String s, String t) {
//         if (t.length() == 0 || s.length() == 0) {
//             return "";
//         }
//         int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;
//         int[] mem = new int[60];
//         int[] in = new int[60];
        
//         formAlpha(t, in);
        
//         String out = "";
        
//         while (p2 < s.length()) {
//             while (!check(mem, in) && p2 < s.length()) {
//                 mem = new int[60];
//                 formAlphaSol(s, mem, p1, p2 + 1);
//                 p2 ++;
//             }
            
//             while(check(mem, in)) {
//                // System.out.println(currentWindow);
//                 if (p2 - p1 < min && p2 - p1 > 0) {
//                     out = s.substring(p1, p2);
//                     min = p2 -p1;
//                 }   
//                 //mem = new int[60];
//                 //formAlphaSol(currentWindow, mem, in);
//                 mem[s.charAt(p1) - 'A'] = mem[s.charAt(p1) - 'A'] - 1;
// //                 System.out.println(Arrays.toString(mem));
// //                 System.out.println(Arrays.toString(in));
                
//                 p1 ++;
//             }
//         }
    
//         return out;
//     }
    
//     public String minWindow(String s, String t) {
//         if (s.length() == 0 || t.length() == 0) {
//             return "";
//         }
        
//         HashMap<Character, Integer> inp = new HashMap<>();
//         HashMap<Character, Integer> mem = new HashMap<>();
        
//         for (int i = 0; i < t.length(); i ++) {
//             inp.put(t.charAt(i), inp.getOrDefault(t.charAt(i), 0) + 1);
//         }
        
//         int reqLength = inp.size();
//         int windowLength = 0;
//         int p1 = 0, p2 = 0;
//         int[] out = new int[] {Integer.MAX_VALUE, 0, 0};
        
//         while (p2 < s.length()) {
//             Character p2Char = s.charAt(p2);
//             if (inp.containsKey(p2Char)) {
//                 int newCount = mem.getOrDefault(p2Char, 0) + 1;
//                 mem.put(p2Char, newCount);
//                 if (newCount == inp.get(p2Char)) {
//                     windowLength ++;
//                 }
//             }
            
//             while (p1 <= p2 && windowLength == reqLength) {
//                 if ((p2 - p1 + 1) < out[0]) {
//                     out[0] = p2 - p1 + 1;
//                     out[1] = p1;
//                     out[2] = p2;
//                 }
//                 Character p1Char = s.charAt(p1);
//                 int newCount = mem.getOrDefault(p1Char, 1) - 1;
//                 mem.put(p1Char, newCount);
//                 if (inp.containsKey(p1Char) && newCount < inp.get(p1Char)) {
//                     windowLength --;
//                 }
//                 p1 ++;
//             }
            
//             p2 ++;
//         }
//         return out[0] != Integer.MAX_VALUE ? s.substring(out[1], out[2] + 1) : "";
//     }
    
    
    public String minWindow(String s, String t) {
        if (s.length() == 0 ||  t.length() == 0) {
            return "";
        }
        int p1 = 0, p2 = 0;
        int[] res = new int[] {0, 0, Integer.MAX_VALUE};
        
        Map<Character, Integer> inputMap = new HashMap<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        
        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
        }
        
        int currentLength = 0;
        int requiredLength = inputMap.size();
        
        while (p2 < s.length()) {
            char c2 = s.charAt(p2);
            if (inputMap.containsKey(c2)) {
                currentMap.put(c2, currentMap.getOrDefault(c2, 0) + 1);
                if (currentMap.get(c2).equals(inputMap.get(c2))) {
                    currentLength ++;
                }
            }
            
            while (p1 <= p2 && currentLength == requiredLength) {
                if (p2 - p1 + 1 < res[2]) {
                    res[0] = p1;
                    res[1] = p2;
                    res[2] = p2 - p1 + 1;
                }
                char c1 = s.charAt(p1);
                currentMap.put(c1, currentMap.getOrDefault(c1, 1) - 1);
                if (inputMap.containsKey(c1)) {
                    if (currentMap.get(c1) < inputMap.get(c1)) {
                        currentLength --;
                    }
                }
                p1 ++;
            }
            
            p2 ++;
        }
        return res[2] == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
    
}
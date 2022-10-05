class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            int val = s.charAt(i);
            if (val > 64 && val < 91) {
                val += 32;
            }
            if (val > 96 && val < 123) {
                list.add((char) val);
            } else if (val > 47 && val < 58) {
                list.add((char) val);
            }
        }
        int r = list.size() - 1;
        for (int l = 0; l < list.size() / 2; l ++, r --) {
            if (list.get(l) != list.get(r)) {
                return false;
            }
        }
        return true;
    }
}
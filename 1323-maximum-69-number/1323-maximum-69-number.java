class Solution {
    public int maximum69Number (int num) {
        char[] cArray = String.valueOf(num).toCharArray();
        
        for (int i = 0; i < cArray.length; i ++) {
            if (cArray[i] == '6') {
                cArray[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(cArray));
    }
}
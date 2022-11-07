class Solution {
    // public int maximum69Number (int num) {
    //     char[] ca = String.valueOf(num).toCharArray();
    //     for (int i = 0; i < ca.length; i ++) {
    //         if (ca[i] == '6') {
    //             ca[i] = '9';
    //             break;
    //         }
    //     }
    //     return Integer.parseInt(new String(ca));
    // }
    
    
    public int maximum69Number (int num) {
        int temp = num;
        int index = -1;
        int i = 0;
        while (temp > 0) {
            int r = temp % 10;
            if (r == 6) {
                index = i;
            }
            temp = temp / 10;
            i ++;
        }
        return index != -1 ? (int) (num + 3 * Math.pow(10, index)) : num;
    }
    
}
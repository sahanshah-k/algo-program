class Solution {
    public int compress(char[] chars) {
        int currentCount = 1;
        int k = 0;
        for (int i = 1; i < chars.length; i ++) {
            if (chars[i - 1] != chars[i]) {
                chars[k++] = chars[i - 1];
                if (currentCount > 1) {
                    k += setDigit(chars, k, currentCount);
                }
                currentCount = 0;
            }
            currentCount ++;
        }
        
        chars[k++] = chars[chars.length - 1];
        if (currentCount > 1) {
            k += setDigit(chars, k, currentCount);
        }
        return k;
    }
    
    private int setDigit(char[] chars, int k, int num) {
        
        
        // int len = (int) (Math.log10(num) + 1);  
        // int temp = len;
        // while (len > 0) {
        //     int p = (int) Math.pow(10, len - 1);
        //     int q = num / p;
        //     //System.out.println(num);
        //     chars[k] = (char) (q + '0');
        //     k ++;
        //     num = num % p;
        //     len --;
        // }
        // return temp;
        
        String t = String.valueOf(num);
        for (int i = 0; i < t.length(); i ++, k ++) {
            chars[k] = t.charAt(i);
        }
        return t.length();
    }
}
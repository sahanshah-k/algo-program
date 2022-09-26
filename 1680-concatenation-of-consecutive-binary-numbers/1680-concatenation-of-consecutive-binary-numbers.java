class Solution {
    // public int concatenatedBinary(int n) {
    //     final long modulo = (long) (1e9 + 7);  
    //     long result = 0;
    //     for (int i = 1; i <= n; i++) {
    //         int temp = i;
    //         while (temp > 0) {
    //             temp /= 2;
    //             result *= 2;
    //         }
    //         result = (result + i) % modulo;
    //     }
    //     return (int) result;
    // }
    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int binaryDigits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) binaryDigits++;
            result = ((result << binaryDigits) + i) % modulo;
        }
        return (int) result;
    }

}
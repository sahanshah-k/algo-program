public class MonotoneIncreasingDigits {

    public static void main(String[] args) {
        //System.out.println(isMonotonic(963856657));
        System.out.println(monotoneIncreasingDigits2(1234));
    }

    public static int monotoneIncreasingDigits(int n) {
        for (int i = n; i >= 0; i--) {
            String intString = String.valueOf(i);
            if (intString.length() <= 1 || isMonotonic(i)) {
                return i;
            }
        }
        return 0;
    }

    public static boolean isMonotonic(int i) {
        int temp = i;
        int first = temp % 10;
        temp = temp / 10;
        while (temp > 0) {
            int second = temp % 10;
            temp = temp / 10;
            if (first < second) {
                return false;
            }
            first = second;
        }
        return true;
    }

    //963856657
    public static int monotoneIncreasingDigits2(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int lastPos = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                continue;
            else {
                arr[i]--;
                lastPos = i + 1;
            }
        }
        for (int j = lastPos; j < arr.length; j++)
            arr[j] = '9';
        return Integer.valueOf(new String(arr));
    }

}

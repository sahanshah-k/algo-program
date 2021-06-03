public class LongestPeak {

    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{5, 4, 3, 2, 1, 2, 10, 12}));
    }

    public static int longestPeak(int[] array) {
        if (array.length < 3) {
            return 0;
        }
        int count = 0;
        int peak = Integer.MIN_VALUE;
        int peakIndex = -1;
        for (int i = 0; i < array.length - 2; i ++) {
            if (array[i] < array[i + 1] && array[i + 1] > array[i + 2] && array[i + 1] > peak) {
                peak = array[i + 1];
                peakIndex = i + 1;
            }
        }
        if (peakIndex != -1) {
            int index = peakIndex;
            while (index < array.length - 1) {
                if (array[index] > array[index + 1]) {
                    index++;
                    count++;
                } else {
                    break;
                }
            }
            while (peakIndex > 0) {
                if (array[peakIndex] > array[peakIndex - 1]) {
                    peakIndex--;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count > 0 ? count + 1: 0;
    }
}

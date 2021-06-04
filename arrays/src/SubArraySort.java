import java.util.Arrays;

public class SubArraySort {

/*Q : function that takes in an array of at least two integers and
      that returns an array of starting and ending indices of the smallest
      subarray in input array that needs to be SORTED in order for the
      entire input array to be sorted.
      if already sorted we should return [-1, -1]
      input: [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
      output: [3,9]
    */

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        subArraySort(
                                new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}
                        )
                )
        );
    }

    public static int[] subArraySort(int[] array) {

        int smallOutOfOrder = Integer.MAX_VALUE;
        int largeOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i ++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)){
                smallOutOfOrder = Math.min(array[i], smallOutOfOrder);
                largeOutOfOrder = Math.max(array[i], largeOutOfOrder);
            }
        }

        int subLeftIndex = 0;
        while (smallOutOfOrder >= array[subLeftIndex]) {
            subLeftIndex ++;
        }

        int subRightIndex = array.length - 1;
        while (largeOutOfOrder < array[subRightIndex]) {
            subRightIndex --;
        }

        return new int[] {subLeftIndex, subRightIndex};
    }

    public static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num > array[i + 1] || num < array[i - 1];
    }

}

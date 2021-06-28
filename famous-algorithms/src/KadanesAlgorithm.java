public class KadanesAlgorithm {

    public static void main(String[] args) {
        System.out.println(kadanesAlgorithm(new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}));
    }

    /**
     * Write a function that takes in a non-empty array of integers and returns the maximum
     * sum that can be obtained by summing up all of the integers in a non-empty
     * subarray of the input array. A subarray must only contain adjacent numbers
     * (numbers next to each other in the input array).
     *
     *
     */

    public static int kadanesAlgorithm(int[] array) {
        int maxSum = array[0];
        int previousSum = array[0];
        for (int i = 1; i < array.length; i ++) {
            previousSum = Math.max(previousSum + array[i], array[i]);
            maxSum = Math.max(previousSum, maxSum);
        }
        return maxSum;
    }

}

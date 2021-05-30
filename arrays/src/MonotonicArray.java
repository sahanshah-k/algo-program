public class MonotonicArray {

    public static void main(String[] args) {

        System.out.println(isMonotonic2(
                new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11})
        );

    }


    public static boolean isMonotonic(int[] array) {

        if (array.length <= 2) return true;

        boolean increasing = false;
        boolean setOrder = false;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                if (!setOrder) {
                    increasing = array[i] < array[i + 1];
                    setOrder = true;
                }

                if (increasing) {
                    if (array[i] > array[i + 1]) {
                        return false;
                    }
                } else {
                    if (array[i] < array[i + 1]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isMonotonic2(int[] array) {

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                isDecreasing = false;
            } else if (array[i] > array[i + 1]) {
                isIncreasing = false;
            }
        }
        return isDecreasing || isIncreasing;
    }
}
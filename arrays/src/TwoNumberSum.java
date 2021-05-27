import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {

    public static void main(String args[]) {
        System.out.println(Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        HashSet<Integer> integerHashSet = new HashSet<>();

        for (int i = 0; i < array.length; i ++) {
            int difference = targetSum - array[i];
            if (integerHashSet.contains(difference)) {
                return new int[]{difference, array[i]};
            } else {
                integerHashSet.add(array[i]);
            }
        }
        return new int[0];
    }

}

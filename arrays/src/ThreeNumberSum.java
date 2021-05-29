import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String args[]) {

        System.out.println(Arrays.toString(threeNumberSum(
                new int[]{12, 3, 1, 2, -6, 5, -8, 6},
                0
        ).toArray()));

    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> out = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int comp = array[i];
            int lx = i + 1;
            int rx = array.length - 1;
            while (lx < rx) {
                int sum = comp + array[lx] + array[rx];
                if (sum == targetSum) {
                    out.add(new Integer[]{comp, array[lx], array[rx]});
                    lx++;
                    rx--;
                } else if (sum < targetSum) {
                    lx++;
                } else if (sum > targetSum) {
                    rx--;
                }
            }
        }
        return out;
    }

}

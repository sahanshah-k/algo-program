import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

    public static void main(String[] args) {

    }

    //{a,b},{c,d} -> P, Q like twoSum
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        Map<Integer, List<Integer[]>> allPairSum = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int diff = targetSum - currentSum;
                if (allPairSum.containsKey(diff)) {
                    for (Integer[] pair : allPairSum.get(diff)) {
                        quadruplets.add(
                                new Integer[]{array[i], array[j], pair[0], pair[1]}
                        );
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[i], array[k]};
                if (allPairSum.containsKey(currentSum)) {
                    allPairSum.get(currentSum).add(pair);
                } else {
                    allPairSum.put(currentSum,
                            new ArrayList<Integer[]>() {{
                                add(pair);
                            }}
                    );
                }
            }

        }
        return quadruplets;
    }

}

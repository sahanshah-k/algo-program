import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static void main(String[] args) {

        System.out.println(
                Arrays.toString(
                        largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6})
                )
        );
    }

    public static int[] largestRange(int[] array) {
        int[] outputRange = new int[2];
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        int longestRange = 0;
        for (int num : array) {
            visitedMap.put(num, false);
        }
        for (int num : array) {
            if (visitedMap.get(num)) {
                continue;
            }
            visitedMap.put(num, true);

            int currentLength = 1;
            int left = num - 1;
            int right = num + 1;

            while (visitedMap.containsKey(left)) {
                visitedMap.put(left, true);
                currentLength++;
                left--;
            }

            while (visitedMap.containsKey(right)) {
                visitedMap.put(right, true);
                currentLength++;
                right++;
            }

            if (currentLength > longestRange) {
                longestRange = currentLength;
                outputRange[0] = left + 1;
                outputRange[1] = right - 1;
            }
        }
        return outputRange;
    }

}

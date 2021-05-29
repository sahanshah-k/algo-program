import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

    public static void main(String args[]) {
        System.out.println(isValidSubsequence(
                Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10),
                Arrays.asList(1, 6, -1, 10)
        ));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int pointA = 0;
        int pointS = 0;

        while (pointA < array.size() && pointS < sequence.size() && pointS != sequence.size()) {
            if (array.get(pointA).equals(sequence.get(pointS))) {
                pointS++;
            }
            pointA++;
        }

        return pointS == sequence.size();
    }

}

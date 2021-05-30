import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveElementToEnd(
                Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2),
                2
        ).toArray()));
    }

    //move all given nums to end.

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int i = 0;
        int j = array.size() - 1;

        while (i < j) {
            while (i < j && array.get(j) == toMove) {
                j --;
            }
            if (array.get(i) == toMove) {
                swap(i, j , array);
            }
            i ++;
        }

        return array;
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

}

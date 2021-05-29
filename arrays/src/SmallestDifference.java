import java.util.Arrays;

public class SmallestDifference {

    public static void main(String a[]) {
        System.out.println(Arrays.toString(smallestDifference(
                new int[]{-1, 5, 10, 20, 28, 3},
                new int[]{26, 134, 135, 15, 17}
        )));
    }


    //return one value from each array whose difference is closest to zero

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int oneX = 0;
        int twoX = 0;

        int[] out = new int[2];

        int smallestDifference = Integer.MAX_VALUE;

        while (oneX < arrayOne.length && twoX < arrayTwo.length) {
            int oneV = arrayOne[oneX];
            int twoV = arrayTwo[twoX];
            int diff = Math.abs(oneV - twoV);
            if (diff < smallestDifference) {
                out[0] = oneV;
                out[1] = twoV;
                smallestDifference = diff;
            }

            if (oneV == twoV) {
                return new int[]{oneV, twoV};
            } else if (oneV < twoV) {
                oneX ++;
            } else if (twoV < oneV) {
                twoX ++;
            }
        }
        return out;
    }

}

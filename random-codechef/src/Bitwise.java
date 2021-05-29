import java.io.IOException;

public class Bitwise {

    public static void main(String args[]) throws IOException {

        java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        int testCase = Integer.parseInt(r.readLine());
        Integer[] result = new Integer[testCase];
        for (int t = 0; t < testCase; t++) {
            int len = Integer.parseInt(r.readLine());
            Integer[] c = new Integer[len];
            String inputLine = r.readLine();

            String[] inputLineArray = inputLine.split(" ");

            for (int i = 0; i < inputLineArray.length; i++) {
                c[i] = Integer.parseInt(inputLineArray[i]);
            }
            result[t] = getMatchingValue(len, c);
        }
        for (int t = 0; t < testCase; t++) {
            System.out.println(result[t]);
        }
    }

    private static Integer getMatchingValue(Integer len, Integer[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i ++){
            for (int j = i + 1; j < array.length; j ++) {
                Integer x = array[i];
                Integer y = array[j];
                if ((x|y) <= Math.max(x,y)) {
                    count ++;
                }
            }
        }
        return count;
    }

}

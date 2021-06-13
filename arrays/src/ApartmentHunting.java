import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {


    public static void main(String[] args) {

        System.out.println(
                apartmentHunting2(
                        new ArrayList<Map<String, Boolean>>() {{
                            add(
                                    new HashMap<String, Boolean>() {{
                                        put("gym", false);
                                        put("school", true);
                                        put("store", false);
                                    }}
                            );
                            add(
                                    new HashMap<String, Boolean>() {{
                                        put("gym", true);
                                        put("school", false);
                                        put("store", false);
                                    }}
                            );
                            add(
                                    new HashMap<String, Boolean>() {{
                                        put("gym", true);
                                        put("school", true);
                                        put("store", false);
                                    }}
                            );
                            add(
                                    new HashMap<String, Boolean>() {{
                                        put("gym", false);
                                        put("school", true);
                                        put("store", false);
                                    }}
                            );
                            add(
                                    new HashMap<String, Boolean>() {{
                                        put("gym", false);
                                        put("school", true);
                                        put("store", true);
                                    }}
                            );
                        }},
                        new String[]{"gym", "school", "store"}
                )
        );
    }

    //O(blocks^2*req) time | O(1)
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        int[] pair = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int i = 0; i < blocks.size(); i++) {
            int tempMax = Integer.MIN_VALUE;
            for (String req : reqs) {
                int tempMin = Integer.MAX_VALUE;
                for (int k = 0; k < blocks.size(); k++) {
                    if (blocks.get(k).get(req)) {
                        tempMin = Math.min(tempMin, Math.abs(i - k));
                    }
                }
                tempMax = Math.max(tempMax, tempMin);
            }
            if (tempMax < pair[1]) {
                pair[0] = i;
                pair[1] = tempMax;
            }
        }
        return pair[0];
    }


    public static int apartmentHunting2(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] reqBlock = new int[reqs.length][];
        for (int i = 0; i < reqs.length; i++) {
            reqBlock[i] = findDistance(blocks, reqs[i]);
        }
        return findMaxAndReturnMin(reqBlock, blocks, reqs);
    }

    public static int[] findDistance(List<Map<String, Boolean>> blocks, String req) {
        int[] minDistances = new int[blocks.size()];
        int closestIndex = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(req)) {
                closestIndex = i;
            }
            minDistances[i] = Math.abs(i - closestIndex);
        }
        for (int i = blocks.size() - 1; i >= 0; i--) {
            if (blocks.get(i).get(req)) {
                closestIndex = i;
            }
            minDistances[i] = Math.min(minDistances[i], Math.abs(i - closestIndex));
        }
        return minDistances;
    }

    public static int findMaxAndReturnMin(int[][] reqBlock, List<Map<String, Boolean>> blocks, String[] reqs) {
        int tempMin = Integer.MAX_VALUE;
        int tempMinIndex = -1;
        for (int i = 0; i < blocks.size(); i++) {
            int tempMax = Integer.MIN_VALUE;
            for (int j = 0; j < reqs.length; j++) {
                tempMax = Math.max(tempMax, reqBlock[j][i]);
            }
            if (tempMax < tempMin) {
                tempMinIndex = i;
                tempMin = tempMax;
            }
            tempMin = Math.min(tempMin, tempMax);
        }
        return tempMinIndex;
    }
}

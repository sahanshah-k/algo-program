class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < growTime.length; i ++) {
            indices.add(i);
        }

        Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        int out = 0;
        for (int i = 0, currentPlantTime = 0; i < growTime.length; i ++) {
            int index = indices.get(i);
            int currentTotalTime = plantTime[index] + growTime[index] + currentPlantTime;
            out = Math.max(currentTotalTime, out);
            currentPlantTime += plantTime[index];
        }
        return out;
    }
}
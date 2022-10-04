class Solution {
    public int minCost(String colors, int[] neededTime) {
        int p1 = 0, p2 = 0;
        int currentTotal = 0, max = 0, out = 0;
        while (p2 < colors.length()) {
            if (colors.charAt(p1) != colors.charAt(p2)) {
                p1 = p2;
                out += currentTotal - max;
                currentTotal = 0;
                max = 0;
            }
            if (p2 == colors.length() - 1 && p1 != p2) {
                max = Math.max(max, neededTime[p2]);
                currentTotal += neededTime[p2];
                out += currentTotal - max;
            }
            max = Math.max(max, neededTime[p2]);
            currentTotal += neededTime[p2];
            p2 ++;
        }
        return out;
    }
}

public class PeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3}));
    }

    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

}

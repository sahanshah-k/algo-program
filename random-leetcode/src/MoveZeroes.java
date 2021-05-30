public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
    //move zeroes to end
    public static void moveZeroes(int[] nums) {
        int lastNonZeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroPos] = nums[i];
                lastNonZeroPos ++;
            }
        }
        for (int i = lastNonZeroPos; i < nums.length; i ++) {
            nums[i] = 0;
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}

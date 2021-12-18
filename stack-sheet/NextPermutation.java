class Solution {
    
    public void nextPermutation(int[] A) {
        if (A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i --;
        if (i >= 0) {
            int j = A.length - 1;
            while(A[j] <= A[i]) j --;
            swap(A, i, j);
        }
        reverse(A, i + 1, A.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }

}

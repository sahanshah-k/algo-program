class Solution {
    
    /*
    Step 1 : traverse from right find first index, ie i where a[i] < a[i + 1]
    Step 2 : traverse from right find the second index j where a[j] > a[i]
    Step 3 : swap i and j
    Step 4 : reverse from i + 1 index to length - 1 
    
    Step 4 should be done in all the cases
    
    
    It will be always in increasing order from the left, find the breaking point.
    [1 3] [5 4 2]
    find the next first half,
    it will be [1 4]
    ie the next largest element in the second half, traverse from right end.
    swap [1 4] [5 3 2]
    reverse second half
    
    1 4 2 3 5
    */
    
    
    
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

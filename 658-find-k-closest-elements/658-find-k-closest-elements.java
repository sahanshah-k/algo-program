class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> out = new ArrayList<>();
        
        int l = 0;
        int r = arr.length - k;
        int m = 0;
            
        while (l < r) {
            m = (l + r)/2;        
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        for (int i = l; i < l + k; i++) {
            out.add(arr[i]);
        }
        
        return out;
    }
}
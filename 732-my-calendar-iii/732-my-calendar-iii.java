class MyCalendarThree {

    Map<Integer, Integer> map;
    int max;
    public MyCalendarThree() {
        map = new TreeMap<>();
        max = 0;
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int curr = 0;
        for (Integer val: map.values()) {
            curr += val;
            max = Math.max(curr, max);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */